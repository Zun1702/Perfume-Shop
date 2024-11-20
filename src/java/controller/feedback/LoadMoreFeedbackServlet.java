/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.feedback;

import dal.FeedBackDAO;
import dal.ShopDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.Feedback;

/**
 *
 * @author canduykhanh
 */
@WebServlet(name="LoadMoreFeedbackServlet", urlPatterns={"/load"})
public class LoadMoreFeedbackServlet extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadMoreFeedbackServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadMoreFeedbackServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String amount = request.getParameter("exist");
        String pid_raw = request.getParameter("product_id");
        int iamount = Integer.parseInt(amount);
        int pid = Integer.parseInt(pid_raw);
        //lay id cua san pham do
        FeedBackDAO fd = new FeedBackDAO();
        List<Feedback> listf = fd.getNext3Feedback(pid, iamount);
        PrintWriter out = response.getWriter();
        for (Feedback f : listf) {
            out.println("<div class=\"products_cmt-item feedbackok\">\n" +
"                                        <div class=\"products_cmt-top\">\n" +
"                                            <img src=\""+f.getUser().getAvatar()+"\" class=\"img_avatar-user\">\n" +
"                                            <div class=\"user_rated\">\n" +
"                                                <span class=\"user_rated-name\">"+f.getUser().getUsername()+"</span>\n" +
"                                                <div>\n" +
"                                                    <span>\n" +
"                                                        <c:forEach  begin=\"1\" end=\""+f.getRating()+"\">\n" +
"                                                            <i class=\"fa-solid fa-star icon_star\"></i>\n" +
"                                                        </c:forEach>\n" +
"                                                    </span>\n" +
"                                                    <span class=\"user_rated-cmttime\">"+f.getCreated_at()+"</span>\n" +
"                                                </div>\n" +
"                                            </div>\n" +
"                                        </div>    \n" +
"                                        <div class=\"products_cmt-bot\">\n" +
"                                            <p>"+f.getNote()+"\n" +
"                                            </p>\n" +
"                                        </div>\n" +
"                                    </div>");
        }
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
