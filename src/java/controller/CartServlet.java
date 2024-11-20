/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AddressDAO;
import dal.CartDAO;
import dal.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.Address_Detail;
import model.Cart;
import model.Discount;
import model.Item;
import model.SizeProduct;
import model.User;

/**
 *
 * @author ASUS
 */
@WebServlet(name="CartServlet", urlPatterns={"/cart"})
public class CartServlet extends HttpServlet {
   
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
        Cookie[] arr=request.getCookies();
       ProductDAO pdao=new ProductDAO();
        String txt="";
        if(arr!=null){
            for (Cookie o:arr) {
                if(o.getName().equals("cart"))
                txt+=o.getValue();
            }
        }
        CartDAO cdao=new CartDAO();
        AddressDAO adao=new AddressDAO();
        HttpSession session=request.getSession();
        
        List<Discount> ld=cdao.getAllDiscount();
         User a= (User) request.getSession().getAttribute("userNow");
         Address_Detail ad=adao.getDefaultAddress(a.getId());
        Cart cart=new Cart(txt,a);
        List<Item> listItem= cart.getItems();
        int n;
        
        if(listItem!=null){
            n=listItem.size();
        }else{
            n=0;
        }
        
        session.setAttribute("ad", ad);
        request.setAttribute("ld", ld);
        request.setAttribute("totalQuan", n);
        request.setAttribute("listItem", listItem);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
        processRequest(request, response);
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
