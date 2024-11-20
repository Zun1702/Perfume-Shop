/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin;

import dal.DashboardDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Calendar;
import model.Address_Detail;
import model.User;

/**
 *
 * @author asus
 */
@WebServlet(name = "AddAccount", urlPatterns = {"/addaccount"})
public class AddAccount extends HttpServlet {

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
            out.println("<title>Servlet AddAccount</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAccount at " + request.getContextPath() + "</h1>");
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
//        String check = request.getParameter("email");
//        String msg ;
//        if (check!=null) {
//            msg ="Create account successful!";
//        }
//        else{
//            msg="Create account sai sai!";
//        }
//        request.setAttribute("msg", msg);
        request.getRequestDispatcher("dashboard/addaccount.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String phonenum = request.getParameter("phonenum");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String role_id_raw = request.getParameter("role");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String image = request.getParameter("image");
        int role_id = Integer.parseInt(request.getParameter("roleid"));

//        String created_date = request.getParameter("created_date");
//        int price = Integer.parseInt(price_raw);
//        int cid = Integer.parseInt(cid_raw);
        DashboardDAO d = new DashboardDAO();
//        String msg ="Create account successful!";
        java.sql.Date curDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try {
            // role, firstname, lastname, username, password, email, phonenum, create, update, isDelete

            User u = new User(role_id, firstname, lastname, username, password, email, phonenum, curDate, null, 0, image);
            d.addAccount(u);
            response.sendRedirect("addaddress");

        } catch (NumberFormatException e) {
            System.out.println(e);
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
