package com.greenacademy.servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    //! Tampilan awal login
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            response.sendRedirect(request.getContextPath()+"/");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
    }

    //! Proses login (ketika form login di submit)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean rememberMe = request.getParameter("remember_me") !=null;

        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            if(rememberMe){
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(60*2); //set masa expired cookienya
                cookie.setPath("/"); //set the path for the cookie
                response.addCookie(cookie);
            }
            response.sendRedirect(request.getContextPath() + "/");

        } else {
            request.setAttribute("error", "Username / Password Salah");
            request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
        }
    }
    
}
