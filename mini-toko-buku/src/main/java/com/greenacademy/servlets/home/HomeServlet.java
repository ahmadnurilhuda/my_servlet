package com.greenacademy.servlets.home;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.models.Book;



@WebServlet("")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");

        //! Get Cookie
        Cookie [] cookies = request.getCookies();

        if(cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("username")){
                    request.getSession().setAttribute("username", cookie.getValue());
                }
            }
        }
        //! Cek apakah user sudah login
        String username = (String) request.getSession().getAttribute("username");

        
        if (username == null) {
            response.sendRedirect("login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/views/home/home.jsp").forward(request, response);
    }
    
}
