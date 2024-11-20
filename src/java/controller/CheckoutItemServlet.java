/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AddressDAO;
import dal.CartDAO;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.User;


/**
 *
 * @author ASUS
 */
@WebServlet(name = "CheckoutItemServlet", urlPatterns = {"/checkoutitem"})
public class CheckoutItemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckoutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] arr = request.getCookies();
        CartDAO cdao=new CartDAO();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
       
        
        List<Discount> ld=cdao.getAllDiscount();
        User u = (User) request.getSession().getAttribute("userNow");
        Cart cart = new Cart(txt, u);
        List<Item> listItem = cart.getItems();
        int totalQuantity = 0;
        for (Item item : listItem) {
            if (!listItem.isEmpty()) {
                totalQuantity = totalQuantity + item.getQuantity();
            }

        }
        AddressDAO adao = new AddressDAO();
        List<Address_Detail> listad = adao.getAddressByUserID(u.getId());

        Address_Detail ad = (Address_Detail) request.getSession().getAttribute("ad");

        int countAddress = listad.size();

        request.setAttribute("ld", ld);
        request.setAttribute("ad", ad);
        request.setAttribute("listad", listad);
        request.setAttribute("countAddress", countAddress);
        request.setAttribute("totalQuan", totalQuantity);
        request.setAttribute("listItem", listItem);
        request.setAttribute("cart", cart);
        
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }



    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) request.getSession().getAttribute("userNow");
        int address_id = Integer.parseInt(request.getParameter("radio_address"));
        String action = request.getParameter("action");
        AddressDAO adao = new AddressDAO();
        CartDAO cdao=new CartDAO();
        
        if (action.equals("action1")) {
            Address_Detail ad = adao.getAddressDetailByID(address_id);
            session.setAttribute("ad", ad);
            response.sendRedirect("checkoutitem");

        } else if(action.equals("action2")){
            
        
            
            String note = request.getParameter("note");
            OrderDAO dao = new OrderDAO();

                Cookie[] arr = request.getCookies();
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
                Cart cart = new Cart(txt, u);
                List<Discount> ld=cdao.getAllDiscount();
                dao.addOrder(u, address_id, cart, note,ld);

                String[] items = txt.split("/");
                String remain = "";
                for (String item : items) {
                    String[] s = item.split(":");
                    if (u != null) {
                        if (!s[0].equals("" + u.getId())) {
                            if (remain.isEmpty()) {
                                remain = item;
                            } else {
                                remain += "/" + item;
                            }
                        }
                    }
                }
                if (!remain.isEmpty()) {
                    Cookie c = new Cookie("cart", remain);
                    c.setMaxAge(60 * 60 * 2 * 24);
                    response.addCookie(c);
                }
                session.removeAttribute("note");
                response.sendRedirect("myOrder");
              
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
