/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.profile;

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
import model.Order;
import model.Product;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "ViewOwnOrder", urlPatterns = {"/myOrder"})
public class ViewOwnOrder extends HttpServlet {

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
            out.println("<title>Servlet ViewOwnOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewOwnOrder at " + request.getContextPath() + "</h1>");
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
        User usernow = (User) session.getAttribute("userNow");
        OrderDAO dao = new OrderDAO();
        AddressDAO adao = new AddressDAO();
        int sumOrder = dao.getNumberOfOrder(usernow.getId());
        int sumAddress = adao.getTotalAddress(usernow.getId());
        
        
        
        request.setCharacterEncoding("UTF-8");
        int pageIndex = 1;
        try {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        } catch (Exception e) {

        }
        int pageSize = 12;
        int totalRow = dao.getNumberOfOrder(usernow.getId());
        int maxPage=0;
        if(totalRow==0){
            request.setAttribute("message", "Không tìm thấy sản phẩm phù hợp");
        }
        else{
            //Tìm xem có bao nhiêu trang  : 13/4 =3  +1 =4
            maxPage = totalRow/pageSize  + (totalRow%pageSize > 0  ? 1:0);
            int nextPage = pageIndex+1;
            int backPage = pageIndex-1;
            List<Order> listOrder = dao.getOrderByUserIdOrderByDate(usernow.getId(), pageIndex, pageSize);
            request.setAttribute("listOrder", listOrder);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("nextPage", nextPage);
            request.setAttribute("backPage", backPage);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("total", totalRow);
        }
        
        
        
        request.setAttribute("sumOrder", sumOrder);
        request.setAttribute("sumAddress", sumAddress);
       
        request.getRequestDispatcher("order.jsp").forward(request, response);
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
