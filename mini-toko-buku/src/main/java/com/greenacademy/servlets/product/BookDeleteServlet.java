package com.greenacademy.servlets.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.service.BookService;

@WebServlet("/books/delete/*")
public class BookDeleteServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String pathInfo = request.getPathInfo();
        String bookId = (pathInfo != null) ? pathInfo.substring(1) : null;

        if (bookId == null || bookId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book ID is Missing");
            return;
        } else {

            BookService bookService = new BookService(request);
            bookService.deleteBook(bookId);

            response.sendRedirect(request.getContextPath() + "/books");

        }

    }

}
