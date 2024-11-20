/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

//import dal.CartDAO;
import dal.DashboardDAO;
import dal.FeedBackDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Feedback;
import model.Gallery;
import model.Gender;
import model.Product;
import model.Size;
import model.SizeProduct;
import model.User;

/**
 *
 * @author asus
 */
@WebServlet(name = "DetailServlet", urlPatterns = {"/pdetail"})
public class DetailServlet extends HttpServlet {

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
            out.println("<title>Servlet DetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        String sid_raw = request.getParameter("sid");
        String gid_raw = request.getParameter("gid");
//        String quantity_raw = request.getParameter("quantity");
//        
//        int quantity = Integer.parseInt(quantity_raw);
        int id = Integer.parseInt(id_raw);
        int sid = Integer.parseInt(sid_raw);
        int gid = Integer.parseInt(gid_raw);
        request.setAttribute("sizeid", sid);
        DashboardDAO dd  = new DashboardDAO();
        ProductDAO dao = new ProductDAO();
        request.setAttribute("pQuantity", dd.getQuantity(id, sid));
        request.setAttribute("msg", "Trong kho chỉ còn lại "+dd.getQuantity(id, sid)+" sản phẩm");
//        request.setAttribute("quantity", quantity);
        
        Product p = dao.getProductByID(id);

        SizeProduct getP = dao.getSizeProductByPidSid(id, sid);

        List<Size> ls = dao.getSizeByPID(id);

        List<Gallery> listg = dao.getGalleryByPid(id);

        Category getC = dao.getCategoryNameById(p.getCategory().getId());

        Gender g = dao.getGenderByID(id);
        List<Product> lg;

        FeedBackDAO fb = new FeedBackDAO();
        List<Feedback> listF = fb.getTop3NewFeedbackByPid(id);
        try {
            lg = dao.randomRelative(gid, id);
            request.setAttribute("relativeproducts", lg);
        } catch (SQLException ex) {
        }
        request.setAttribute("cate", getC);
        request.setAttribute("detail", getP);
        request.setAttribute("product", p);
        request.setAttribute("size", ls);
        request.setAttribute("gender", g);
        request.setAttribute("listgallery", listg);
        request.setAttribute("listF", listF);
        request.setAttribute("sid", sid);
        request.setAttribute("gid", gid);


        request.getRequestDispatcher("productdetail.jsp").forward(request, response);
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
//        HttpSession session = request.getSession();
//        String id_raw = request.getParameter("id");
//        String sid_raw = request.getParameter("sid");
//        String gid_raw = request.getParameter("gid");
//        String note = request.getParameter("review");
//        String rating_raw = request.getParameter("rating");
//        User userNow = (User) session.getAttribute("userNow");
//        int rating;
//        if (userNow != null) {
//            try {
//                int id = Integer.parseInt(id_raw);
//                int sid = Integer.parseInt(sid_raw);
//                int gid = Integer.parseInt(gid_raw);
//                ProductDAO dao = new ProductDAO();
//                Product p = dao.getProductByID(id);
//                rating = Integer.parseInt(rating_raw);
//                FeedBackDAO fb = new FeedBackDAO();
//                fb.insertFeedback(userNow, p, note, rating);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            response.sendRedirect("pdetail?id=" + id_raw + "&sid=" + sid_raw +"&gid=" +gid_raw);
//        }else{
//            response.sendRedirect("login");
//        }
//        FeedBackDAO f = new FeedBackDAO();
//        HttpSession session = request.getSession();
//        String id_raw = request.getParameter("id");
//        String sid_raw = request.getParameter("sid");
//        String gid_raw = request.getParameter("gid");
//        String note = request.getParameter("review");
//        String rating_raw = request.getParameter("rating");
//        User userNow = (User) session.getAttribute("userNow");
//        int id = Integer.parseInt(id_raw);
//        int rating;
//        int value = f.checkF(userNow.getId(), id).size();
//        int flag = f.checkOrder(userNow.getId(), id).size();
//        if (value < flag) {
//            if (userNow != null) {
//                try {
//                    int sid = Integer.parseInt(sid_raw);
//                    int gid = Integer.parseInt(gid_raw);
//                    ProductDAO dao = new ProductDAO();
//                    Product p = dao.getProductByID(id);
//                    rating = Integer.parseInt(rating_raw);
//                    FeedBackDAO fb = new FeedBackDAO();
//                    fb.insertFeedback(userNow, p, note, rating);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//                session.removeAttribute("note");
//                response.sendRedirect("pdetail?id=" + id_raw + "&sid=" + sid_raw + "&gid=" + gid_raw);
//            } else {
//                 session.removeAttribute("note");
//                response.sendRedirect("login");
//            }
//        } else {
//            session.setAttribute("note", "Mua hàng trước khi đánh giá !!!");
//            response.sendRedirect("pdetail?id=" + id_raw + "&sid=" + sid_raw + "&gid=" + gid_raw);
//        }

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
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getProductByID(17).getCategory());
    }
}
