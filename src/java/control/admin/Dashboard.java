/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin;

import dal.CategoryDAO;
import dal.DashboardDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;

/**
 *
 * @author asus
 */
@WebServlet(name = "Dashboard", urlPatterns = {"/dashboard"})
public class Dashboard extends HttpServlet {

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
            out.println("<title>Servlet Dashboard</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Dashboard at " + request.getContextPath() + "</h1>");
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
        String year_raw = request.getParameter("year");
        int year;
        if (year_raw != null) {
            year = Integer.parseInt(year_raw);
        } else {
            year = 2023;
        }

        DashboardDAO dd = new DashboardDAO();
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        List<User> u = dd.getNewestUser();
        List<Order> o = dd.getAllSuccessOrder(year);
        List<Product> p = pd.getAllProduct();
        List<Category> c = cd.getAllCategory();
        List<Order> allyear = dd.getAllYear();

        int  totalorders = 0, totalproducts = 0, totalcates = 0;
        for (Order order : o) {
            totalorders += 1;

        }
        for (Product product : p) {
            totalproducts += 1;
        }
        for (Category category : c) {
            totalcates += 1;
        }
        List<OrderDetail> od;

        if (year_raw != null) {
            int totalmoney = 0 ;
            od = dd.getRevenueByEachMonth(year);
            for (OrderDetail orderDetail : od) {
                totalmoney += orderDetail.getOrder().getTotal_money();
            }
            request.setAttribute("totalmoney", totalmoney);
            request.setAttribute("avgMoney", totalmoney / 12);
            request.setAttribute("revenueByMonth", od);
        } else {
            int totalmoney = 0;
            od = dd.getRevenueByEachMonth(2023);
            for (OrderDetail orderDetail : od) {
                totalmoney += orderDetail.getOrder().getTotal_money();
            }
            request.setAttribute("totalmoney", totalmoney);
            request.setAttribute("avgMoney", totalmoney / 12);
            request.setAttribute("revenueByMonth", od);
        }
        List<OrderDetail> od2;
        if (year_raw != null) {
            od2 = dd.getProfitEachMonth(year);
            request.setAttribute("profit", od2);
        } else {
            request.setAttribute("profit", dd.getProfitEachMonth(2023));
        }

        request.setAttribute("totalorders", totalorders);
        request.setAttribute("totalProducts", totalproducts);
        request.setAttribute("totalCates", totalcates);
        request.setAttribute("newestUser", u);
        request.setAttribute("allyear", allyear);
        request.setAttribute("year", year);
        request.getRequestDispatcher("dashboard/dashboard.jsp").forward(request, response);
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
