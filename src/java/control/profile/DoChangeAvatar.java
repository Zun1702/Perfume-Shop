/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.profile;

import dal.UserDAO;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author dell
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(name = "DoChangeAvatar", urlPatterns = {"/dochangeavatar"})

public class DoChangeAvatar extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
    public static final String SAVE_DIRECTORY = "avatar";
    
    
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
            out.println("<title>Servlet DoChangeAvatar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoChangeAvatar at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        HttpSession session = request.getSession();
        User usernow = (User) session.getAttribute("userNow");
        UserDAO dao = new UserDAO();
        
        
           
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
               String fileName = "avatar" + usernow.getId() +(int)(Math.random()*100000000)+  ".jpg";
               if (fileName != null && fileName.length() > 0) {
                   String filePath = fullSavePath + File.separator + fileName;
                 
                   // Ghi vào file.
                  
                   part.write(filePath);
                   
                   usernow.setAvatar("avatar/"+fileName);
                   //response.getWriter().print(linkAva);
                   dao.updateAvatar(usernow.getId(), "avatar/"+fileName);
                  
                  // d.changAvarta(fileName,u.getuId() );
               }
           }
       
           // Upload thành công.
          response.sendRedirect("changeProfile");
       
       }
       
//        String uploadPath = "C:\\Users\\dell\\Documents\\GitHub\\SWP_Boon_Bo\\SWP\\web\\avatar"; // specify the upload directory
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
//
//        Part filePart = request.getPart("avatar"); // the name of the input field in HTML form
//        String fileName = (int) (Math.random() * 100000000) + filePart.getSubmittedFileName();
//
//        InputStream fileContent = filePart.getInputStream();
//        Files.copy(fileContent, new File(uploadDir, fileName).toPath());
//        String avatarLink = "avatar/" + fileName;
//        usernow.setAvatar(avatarLink);
//        dao.updateAvatar(usernow.getId(), avatarLink);
//        session.setAttribute("userNow", usernow);
//        response.sendRedirect("changeProfile");
    

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
