/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.address;

import dal.AddressDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.Address_Detail;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "EditAddressServlet", urlPatterns = {"/editaddress"})
public class EditAddressServlet extends HttpServlet {

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
            out.println("<title>Servlet EditAddressServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAddressServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userNow");
        String id = request.getParameter("id");
        AddressDAO dao = new AddressDAO();
        OrderDAO od = new OrderDAO();
        try {
            int aid = Integer.parseInt(id);
            int sumOrder = od.getNumberOfOrder(user.getId());
            int sumAddress = dao.getTotalAddress(user.getId());
            Address_Detail a = dao.getAddressDetailByID(aid);
            request.setAttribute("sumOrder", sumOrder);
            request.setAttribute("sumAddress", sumAddress);
            request.setAttribute("address", a);
            request.getRequestDispatcher("editaddress.jsp").forward(request, response);

        } catch (Exception e) {
        }

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
        User user = (User) session.getAttribute("userNow");
        AddressDAO dao = new AddressDAO();
        String id = request.getParameter("id");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String detail = request.getParameter("detail");
        String def = request.getParameter("default");

        try {
            int aid = Integer.parseInt(id);
            Address_Detail a = dao.getAddressDetailByID(aid);
            a.setCity(city);
            a.setDistrict(district);
            a.setWard(ward);
            a.setDetail(detail);
            if (def == null) {
                a.setIs_default(0);
            } else {
                Address_Detail adr = dao.getAddressDefault(user.getId());
                dao.updateAddressDefault(adr.getId(), 0);
                a.setIs_default(1);
            }
            dao.updateAddress(a);

            response.sendRedirect("address");
        } catch (Exception e) {
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
