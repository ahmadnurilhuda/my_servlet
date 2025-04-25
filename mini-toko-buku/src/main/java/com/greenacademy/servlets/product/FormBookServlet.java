package com.greenacademy.servlets.product;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.models.Book;




@WebServlet("/books/create")
public class FormBookServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // request.getParameter("message");
        
        // request.setAttribute("message","<p style=\"color: red\">Please fill in the form</p>");

        // request.setAttribute("age", Integer.parseInt(request.getParameter("age")));
        
        request.getRequestDispatcher("/WEB-INF/views/products/create-book.jsp").forward(request, response);
    }
}
