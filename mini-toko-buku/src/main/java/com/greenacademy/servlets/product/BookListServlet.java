package com.greenacademy.servlets.product;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.models.Book;
import com.greenacademy.service.BookService;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        

        BookService bookService = new BookService(request);
        ArrayList<Book> listBooks = bookService.getBook();

        String message = (String) request.getSession().getAttribute("message");
        request.getSession().removeAttribute("message");

        request.setAttribute("message", message);
        request.setAttribute("listBooks", listBooks);

        
        request.getRequestDispatcher("/WEB-INF/views/products/details-book.jsp").forward(request, response);

    }

}



// ArrayList<Book> listBooks = new ArrayList<>();

        // // Ambil parameter dan kondisikan nilai default jika null
        // String title = request.getParameter("title");
        // if (title == null)title = "";

        // String isbn = request.getParameter("isbn");
        // if (isbn == null)isbn = "";

        // String yearStr = request.getParameter("year");
        // LocalDate year = null;
        // if (yearStr != null && !yearStr.isEmpty()) {
        //     try {
        //         year = LocalDate.parse(yearStr);
        //     } catch (DateTimeParseException e) {
        //         year = LocalDate.now();
        //     }
        // } else {
        //     year = LocalDate.now();
        // }

        // String priceStr = request.getParameter("price");
        // double price = 0.0;
        // if (priceStr != null && !priceStr.isEmpty()) {
        //     try {
        //         price = Double.parseDouble(priceStr);
        //     } catch (NumberFormatException e) {
        //         price= 0.0;
        //     }
        // }

        // String stockStr = request.getParameter("stock");
        // int stock = 0;
        // if (stockStr != null && !stockStr.isEmpty()) {
        //     try {
        //         stock = Integer.parseInt(stockStr);
        //     } catch (NumberFormatException e) {
        //         stock = 0;

        //     }
        // }

        // Book newBook = new Book(title, price, stock, isbn, year);
        // listBooks.add(newBook);

        // request.setAttribute("books", listBooks);