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
import com.greenacademy.service.BookService;




@WebServlet("/books/create")
public class FormBookServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        
        request.getRequestDispatcher("/WEB-INF/views/products/create-book.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String bookTitle = request.getParameter("title");
        String bookIsbn = request.getParameter("isbn");
        LocalDate bookYear = LocalDate.parse(request.getParameter("year"));
        double bookPrice = Double.parseDouble(request.getParameter("price"));
        int bookStock = Integer.parseInt(request.getParameter("stock"));
        String bookCategory = request.getParameter("category");
        String bookDescription = request.getParameter("description");

        Book book = new Book(bookTitle, bookPrice, bookStock, bookIsbn, bookYear, bookDescription, bookCategory);

        BookService bookService = new BookService(request);
        bookService.addBook(book);

        String message = "Book Add Succesfully";
        request.getSession().setAttribute("message",message);

        response.sendRedirect(request.getContextPath()+"/books");
    }
}
