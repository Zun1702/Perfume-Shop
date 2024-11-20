/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.crud;

import dal.CrudDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.SizeProduct;

/**
 *
 * @author hp
 */
@WebServlet(name = "AddControl2", urlPatterns = {"/add2"})
public class AddControl2 extends HttpServlet {

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
            out.println("<title>Servlet AddControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddControl at " + request.getContextPath() + "</h1>");
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

        String quantity_raw = request.getParameter("quantity");
        String price_in_raw = request.getParameter("price_in");
        String price_out_raw = request.getParameter("price_out");
        String pid_raw = request.getParameter("pid");
        String sid_raw = request.getParameter("sid");
        String check_raw = request.getParameter("check");

        int price_out, price_in, quantity, pid, sid;
        price_out = Integer.parseInt(price_out_raw);
        price_in = Integer.parseInt(price_in_raw);
        quantity = Integer.parseInt(quantity_raw);
        pid = Integer.parseInt(pid_raw);
        sid = Integer.parseInt(sid_raw);

        boolean check = Boolean.parseBoolean(check_raw);

        try {
            CrudDAO d = new CrudDAO();

            if (check) {
                if (d.checkSize(sid, pid)) {
                    d.addQuantity(sid, pid, quantity + d.getSizeProduct(sid, pid).getQuantity());
                } else {
                    d.insertSizeProduct(pid, sid, quantity, price_in, price_out);
                }
            } else {
                d.insertSizeProduct(d.getIdLastProduct().getId(), sid, quantity, price_in, price_out);
            }
            response.sendRedirect("dashboardp");
        } catch (IOException e) {
            System.out.println(e);
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

        processRequest(request, response);

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
