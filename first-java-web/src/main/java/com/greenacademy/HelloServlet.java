package com.greenacademy;

import java.io.IOException;
// import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // PrintWriter out = response.getWriter();

        String name  = request.getParameter("name");
        String age  = request.getParameter("age");
        String color  = request.getParameter("color");
    

        request.setAttribute("nameSet", name);
        request.setAttribute("ageSet", age);
        request.setAttribute("colorSet", color);

        request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(request, response);
    }
    
}
