/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.shop;

import dal.CategoryDAO;
import dal.GenderDAO;
import dal.ShopDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author canduykhanh
 */
@WebServlet(name = "SortController", urlPatterns = {"/sort"})
public class SortController extends HttpServlet {

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
            out.println("<title>Servlet SortController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SortController at " + request.getContextPath() + "</h1>");
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
        ShopDAO shopDAO = new ShopDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        GenderDAO genderDAO = new GenderDAO();
        request.setCharacterEncoding("UTF-8");
        String typeSort = request.getParameter("typeSort");
        int pageIndex = 1;
        String indexPage = request.getParameter("pageIndex");
        try {
            pageIndex = Integer.parseInt(indexPage);
        } catch (NumberFormatException e) {
            System.out.println("Error parse indexpage");
        }
        int pageSize = 9;
        if (typeSort.equals("By price asc")) {
            int maxPage = 0;
            int totalRow = shopDAO.countAllProduct();
            if (totalRow == 0) {
                request.setAttribute("message", "Không tìm thấy sản phẩm phù hợp");
            } else {
                //Tìm xem có bao nhiêu trang  : 13/4 =3  +1 =4
                maxPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);
                int nextPage = pageIndex + 1;
                int backPage = pageIndex - 1;
                List<Product> listP = shopDAO.getAllProductPresentationPagingBySortAscPrice(pageIndex, pageSize);
                request.setAttribute("listP", listP);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("nextPage", nextPage);
                request.setAttribute("backPage", backPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("total", totalRow);
            }
            request.setAttribute("typeSort", typeSort);

        } else if (typeSort.equals("By price desc")) {

            int maxPage = 0;
            int totalRow = shopDAO.countAllProduct();
            if (totalRow == 0) {
                request.setAttribute("message", "Không tìm thấy sản phẩm phù hợp");
            } else {
                //Tìm xem có bao nhiêu trang  : 13/4 =3  +1 =4
                maxPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);
                int nextPage = pageIndex + 1;
                int backPage = pageIndex - 1;
                List<Product> listP = shopDAO.getAllProductPresentationPagingBySortDescPrice(pageIndex, pageSize);
                request.setAttribute("listP", listP);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("nextPage", nextPage);
                request.setAttribute("backPage", backPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("total", totalRow);
            }
            request.setAttribute("typeSort", typeSort);

        } else if (typeSort.equals("AZ")) {
            int maxPage = 0;
            int totalRow = shopDAO.countAllProduct();
            if (totalRow == 0) {
                request.setAttribute("message", "Không tìm thấy sản phẩm phù hợp");
            } else {
                //Tìm xem có bao nhiêu trang  : 13/4 =3  +1 =4
                maxPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);
                int nextPage = pageIndex + 1;
                int backPage = pageIndex - 1;
                List<Product> listP = shopDAO.getAllProductPresentationPagingBySortAZ(pageIndex, pageSize);
                request.setAttribute("listP", listP);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("nextPage", nextPage);
                request.setAttribute("backPage", backPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("total", totalRow);
            }
            request.setAttribute("typeSort", typeSort);

        } else if (typeSort.equals("ZA")) {
            int maxPage = 0;
            int totalRow = shopDAO.countAllProduct();
            if (totalRow == 0) {
                request.setAttribute("message", "Không tìm thấy sản phẩm phù hợp");
            } else {
                //Tìm xem có bao nhiêu trang  : 13/4 =3  +1 =4
                maxPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);
                int nextPage = pageIndex + 1;
                int backPage = pageIndex - 1;
                List<Product> listP = shopDAO.getAllProductPresentationPagingBySortZA(pageIndex, pageSize);
                request.setAttribute("listP", listP);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("nextPage", nextPage);
                request.setAttribute("backPage", backPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("total", totalRow);
            }

            request.setAttribute("typeSort", typeSort);
        }
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
