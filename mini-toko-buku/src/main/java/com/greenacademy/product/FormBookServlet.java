package com.greenacademy.product;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/books/create")
public class FormBookServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/views/products/form-book.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ArrayList<Book> listBooks = new ArrayList<Book>();
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        LocalDate year = LocalDate.parse(request.getParameter("year"));
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Book newBook = new Book(title, price, stock, isbn, year);
        listBooks.add(newBook);

        request.setAttribute("title", newBook.title);
        request.setAttribute("isbn", newBook.isbn);
        request.setAttribute("year", newBook.year);
        request.setAttribute("price", newBook.price);
        request.setAttribute("stock", newBook.stock);
        request.setAttribute("Books", listBooks);

        request.getRequestDispatcher("/WEB-INF/views/products/details-book.jsp").forward(request, response);
    }

    
    
}
