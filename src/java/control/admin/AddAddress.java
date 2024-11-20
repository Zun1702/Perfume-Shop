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
import java.util.List;
import model.Address_Detail;
import model.QuanHuyen;
import model.TinhThanhPho;
import model.User;
import model.XaPhuong;

/**
 *
 * @author asus
 */
@WebServlet(name = "AddAddress", urlPatterns = {"/addaddress"})
public class AddAddress extends HttpServlet {

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
            out.println("<title>Servlet AddAddress</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAddress at " + request.getContextPath() + "</h1>");
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
        DashboardDAO d = new DashboardDAO();
        String cityId_raw = request.getParameter("cityId");
        String districtId_raw = request.getParameter("districtId");
        String wardId_raw = request.getParameter("wardId");

        if (cityId_raw != null) {
            request.setAttribute("cityId", Integer.parseInt(cityId_raw));
            int cityId = Integer.parseInt(cityId_raw);
            TinhThanhPho city = d.getCity(cityId);
            List<QuanHuyen> q = d.getAllDistrict(cityId);
            request.setAttribute("curCity", city);
            request.setAttribute("listDistrict", q);
        } else {
            request.setAttribute("cityId", 1);
            List<QuanHuyen> q = d.getAllDistrict(1);
            request.setAttribute("listDistrict", q);
        }

        if (districtId_raw != null) {
            int districtId = Integer.parseInt(districtId_raw);
            QuanHuyen district = d.getDistrict(districtId);
            List<XaPhuong> x = d.getAllWard(districtId);
            request.setAttribute("districtId", districtId);
            request.setAttribute("curDistrict", district);
            request.setAttribute("listWard", x);
        } else {
            
            request.setAttribute("districtId", 1);
            List<XaPhuong> x = d.getAllWard(1);
            request.setAttribute("listWard", x);
        }
        
        if(wardId_raw!=null){
            int wardId = Integer.parseInt(wardId_raw);
            XaPhuong ward = d.getWard(wardId);
            request.setAttribute("curWard", ward);
            
        }
        else{
            request.setAttribute("wardId", 1); 
        }

        List<TinhThanhPho> t = d.getAllCity();
        request.setAttribute("lastedU", d.getLastestUser());
        request.setAttribute("listCity", t);
        request.getRequestDispatcher("dashboard/addaddress.jsp").forward(request, response);

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
        String city = request.getParameter("finalcity");
        String district = request.getParameter("finaldistrict");
        String ward = request.getParameter("finalward");
        String detail = request.getParameter("detail");
        DashboardDAO d = new DashboardDAO();
        User lastest = d.getLastestUser();
        try {
            // role, firstname, lastname, username, password, email, phonenum, create, update, isDelete
//            response.sendRedirect("addaccount");

            //uid, city, district, ward, detail, status
            Address_Detail ad = new Address_Detail(lastest.getId(), city, district, ward, detail, 1);
            d.addAddress(ad);
            response.sendRedirect("showprofile?id="+lastest.getId());

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
