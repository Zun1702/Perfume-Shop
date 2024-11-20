/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name="LoginFacebookServlet", urlPatterns={"/login-facebook"})
public class LoginFacebookServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginFacebookServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
      dis.forward(request, response);
    } else {
   //   String accessToken = RestFB.getToken(code);
    //  User user = RestFB.getUserInfo(accessToken);
    //  request.setAttribute("id", user.getId());
    //  request.setAttribute("name", user.getName());
      RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
      dis.forward(request, response);
    }
    
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}