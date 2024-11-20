/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CartDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;
import model.Size;
import model.SizeProduct;
import model.User;

/**
 *
 * @author ASUS
 */
@WebServlet(name="ProcessServlet", urlPatterns={"/process"})
public class ProcessServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Cookie[] arr = request.getCookies();
        ProductDAO pdao=new ProductDAO();
        CartDAO cdao=new CartDAO();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        //d
        User u= (User) request.getSession().getAttribute("userNow");
        Cart cart=new Cart(txt,u);
        String pid_raw =request.getParameter("pid");
        String action =request.getParameter("action");
        String sid_raw=request.getParameter("sid");
        String quantity_raw=request.getParameter("quantity");
        int quantity;
        try {
            int pid=Integer.parseInt(pid_raw);
            int sid=Integer.parseInt(sid_raw);
            quantity=Integer.parseInt(quantity_raw);
            
            SizeProduct sp= pdao.getSizeProductByPidSid(pid, sid);
            Product p= pdao.getProductByID(pid);
            Size s=cdao.getSizeByID(sid);
            int storeProduct=sp.getQuantity();
            
            
            if(action.equals("-")&&cart.getQuantity(pid, sid)<=1){
                cart.removeItem(pid, sid);
            }else{
                
                int price= sp.getPrice_out();
                if(action.equals("+")){
                    if(quantity!=storeProduct){
                        cart.addItem(new Item(sp, p, s, 1, price));
                    }
                } else{
                    cart.addItem(new Item(sp, p, s, -1, price));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        List<Item> listItem=cart.getItems();
        txt="";
        if (!listItem.isEmpty()){
            if(u!=null){
                txt=u.getId()+":"+listItem.get(0).getProduct().getId()+":"+listItem.get(0).getSize().getId()+":"+listItem.get(0).getQuantity();
                for (int i=1;i<listItem.size();i++) {
                    txt+="/"+u.getId()+":"+listItem.get(i).getProduct().getId()+":"+listItem.get(i).getSize().getId()+":"+listItem.get(i).getQuantity();
                }
            }
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        response.sendRedirect("cart");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
