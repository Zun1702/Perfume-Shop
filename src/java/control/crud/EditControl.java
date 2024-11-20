/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.crud;

import static control.crud.AddControl1.SAVE_DIRECTORY;
import dal.CrudDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;

/**
 *
 * @author hp
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(name = "EditControl", urlPatterns = {"/edit"})
public class EditControl extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static final String SAVE_DIRECTORY = "images";

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
            out.println("<title>Servlet EditControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditControl at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);

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

        String pid_raw = request.getParameter("pid");
        String title_raw = request.getParameter("title");
        String description_raw = request.getParameter("description");
        String gender_id_raw = request.getParameter("gender_id");
        String sid_old_raw = request.getParameter("sid_old");
        String sid_new_raw = request.getParameter("sid_new");
        String quantity_raw = request.getParameter("quantity");
        String price_in_raw = request.getParameter("price_in");
        String price_out_raw = request.getParameter("price_out");
        String discount_id_raw = request.getParameter("discount_id");
        String category_id_raw = request.getParameter("category_id");
        String thumbnail_raw = request.getParameter("thumbnail");
        
        String fileName = "";
        
            // Đường dẫn tuyệt đối tới thư mục gốc của web app.
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');

            // Thư mục để save file tải lên.
            String fullSavePath = null;
            if (appPath.endsWith("/")) {
                fullSavePath = appPath + SAVE_DIRECTORY;
            } else {
                fullSavePath = appPath + "/" + SAVE_DIRECTORY;
            }

            // Tạo thư mục nếu nó không tồn tại.
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            // Danh mục các phần đã upload lên (Có thể là nhiều file).

            for (Part part : request.getParts()) {
                fileName = title_raw + (int) (Math.random() * 100000000) + ".jpg";
                if (fileName != null && fileName.length() > 0) {
                    String filePath = fullSavePath + File.separator + fileName;

                    // Ghi vào file.
                    part.write(filePath);
                }
            }
        

        int price_out, price_in, quantity, discount_id, gender_id, category_id, sid_new, sid_old, pid;

        price_out = Integer.parseInt(price_out_raw);
        price_in = Integer.parseInt(price_in_raw);
        quantity = Integer.parseInt(quantity_raw);
        discount_id = Integer.parseInt(discount_id_raw);
        gender_id = Integer.parseInt(gender_id_raw);
        category_id = Integer.parseInt(category_id_raw);
        sid_new = Integer.parseInt(sid_new_raw);
        sid_old = Integer.parseInt(sid_old_raw);
        pid = Integer.parseInt(pid_raw);

        CrudDAO crud = new CrudDAO();
        crud.updateProduct(category_id, title_raw, gender_id, discount_id, "images/" + fileName, description_raw, pid);
        crud.updateSizeProduct(pid, sid_old, sid_new, quantity, price_in, price_out);

        response.sendRedirect("dashboardp");
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
