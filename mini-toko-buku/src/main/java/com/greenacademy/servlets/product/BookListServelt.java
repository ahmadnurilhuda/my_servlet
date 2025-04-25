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

@WebServlet("/books")
public class BookListServelt extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        ArrayList<Book> listBooks = new ArrayList<>();

        // Ambil parameter dan kondisikan nilai default jika null
        String title = request.getParameter("title");
        if (title == null)title = "";

        String isbn = request.getParameter("isbn");
        if (isbn == null)isbn = "";

        String yearStr = request.getParameter("year");
        LocalDate year = null;
        if (yearStr != null && !yearStr.isEmpty()) {
            try {
                year = LocalDate.parse(yearStr);
            } catch (DateTimeParseException e) {
                System.out.println("Format tahun tidak valid: " + yearStr);
                year = LocalDate.now();
            }
        } else {
            year = LocalDate.now();
        }

        String priceStr = request.getParameter("price");
        double price = 0.0;
        if (priceStr != null && !priceStr.isEmpty()) {
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                System.out.println("Format harga tidak valid: " + priceStr);
            }
        }

        String stockStr = request.getParameter("stock");
        int stock = 0;
        if (stockStr != null && !stockStr.isEmpty()) {
            try {
                stock = Integer.parseInt(stockStr);
            } catch (NumberFormatException e) {
                System.out.println("Format stok tidak valid: " + stockStr);
            }
        }

        Book newBook = new Book(title, price, stock, isbn, year);
        listBooks.add(newBook);

        request.setAttribute("books", listBooks);

        request.getRequestDispatcher("/WEB-INF/views/products/details-book.jsp").forward(request, response);

    }

}
