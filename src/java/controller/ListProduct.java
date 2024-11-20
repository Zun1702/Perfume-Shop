/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import model.Category;
import model.Gender;
import model.Product;

/**
 *
 * @author asus
 */
@WebServlet(name = "ListProduct", urlPatterns = {"/listproduct"})
public class ListProduct extends HttpServlet {

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
            out.println("<title>Servlet ListProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListProduct at " + request.getContextPath() + "</h1>");
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
        String cid_raw = request.getParameter("cid");
        String gid_raw = request.getParameter("gid");
        int cid = 0, gid = 0;
        if (cid_raw != null && gid_raw == null) {
            cid = Integer.parseInt(cid_raw);
        }
        if (cid_raw == null && gid_raw != null) {
            gid = Integer.parseInt(gid_raw);
        }

        ProductDAO dao = new ProductDAO();
        List<Product> listC, listG = null;
        Category c = dao.getCategoryNameById(cid);
        Gender g = dao.getGender(gid);
        listC = dao.getProductsByCid(cid);
        if (cid_raw == null) {
            listG = dao.getProductsByGid(gid);
        }

//        int page = 0;
//        String pageStr = request.getParameter("page");
//
//        final int PAGE_SIZE = 4;
//
//        List<Product> list = dao.getProductsByCid(cid);
//        int maxPage = list.size() / 4;
//        if (pageStr != null && !pageStr.equals("0")) {
//            page = Integer.parseInt(pageStr);
//        }
//
//        double max = (double) list.size() / (double) 4;
//        if (list.size() % 4 != 0) {
//            maxPage += 1;
//        }
//        int numOfPro = page * PAGE_SIZE;
//        String str = String.valueOf(max - (maxPage - 1));
//        String[] split = str.split("\\.");
//        if (page == maxPage) {
//            if (split[1].equals("25")) {
//                numOfPro = numOfPro - 3;
//            }
//            if (split[1].equals("5")) {
//                numOfPro = numOfPro - 2;
//            }
//            if (split[1].equals("75")) {
//                numOfPro = numOfPro - 1;
//            }
//        }
//        int from = (page - 1) * PAGE_SIZE;
//        if (!(pageStr != null && !pageStr.equals("0"))) {
//            maxPage = 0;
//            from = 0;
//            numOfPro = 0;
//        }
//
//        request.setAttribute("maxPage", maxPage);
//        request.setAttribute("products", list.subList(from, numOfPro));
        request.setAttribute("listbycate", listC);
        request.setAttribute("catename", c);
        request.setAttribute("gendername", g);
        request.setAttribute("listG", listG);
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("listproduct.jsp").forward(request, response);
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
