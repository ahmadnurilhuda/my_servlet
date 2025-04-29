package com.greenacademy.servlets.product;

import java.io.IOException;
import java.time.LocalDate;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.models.Book;
import com.greenacademy.service.BookService;

@WebServlet("/books/edit/*")
public class BookEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        // ! ambil id buku dari URL
        String pathInfo = request.getPathInfo();
        String bookId = pathInfo != null ? pathInfo.substring(1) : null;

        // ! kondisi jika id buku tidak ditemukan
        if (bookId == null || bookId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book ID is Missing");
            return;
        } else {
            // ! setelah dipastikan id book ada, lanjut cari buku berdasarkan id
            BookService bookService = new BookService(request);
            Book bookById = bookService.getBookById(bookId);

            if (bookById == null) {
                response.sendRedirect(request.getContextPath() + "/books");
                return;
            }

            request.setAttribute("book", bookById);
            request.getRequestDispatcher("/WEB-INF/views/products/edit-book.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ambil ID dari URL
        String pathInfo = request.getPathInfo();
        String bookId = (pathInfo != null) ? pathInfo.substring(1) : null;

        if (bookId == null || bookId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book ID is Missing");
            return;
        } else {

            BookService bookService = new BookService(request);
            Book bookById = bookService.getBookById(bookId);
    
            if (bookById == null) {
                response.sendRedirect(request.getContextPath() + "/books");
                return;
            }
    
            // Ambil data dari form
            String bookTitle = request.getParameter("title");
            String bookIsbn = request.getParameter("isbn");
            LocalDate bookYear = LocalDate.parse(request.getParameter("year"));
            double bookPrice = Double.parseDouble(request.getParameter("price"));
            int bookStock = Integer.parseInt(request.getParameter("stock"));
            String bookCategory = request.getParameter("category");
            String bookDescription = request.getParameter("description");
    
            bookById.setTitle(bookTitle);
            bookById.setIsbn(bookIsbn);
            bookById.setYear(bookYear);
            bookById.setPrice(bookPrice);
            bookById.setStock(bookStock);
            bookById.setDescription(bookDescription);
            bookById.setCategory(bookCategory);
    
            bookService.updateBook(bookById);

            String message = "Book Updated Succesfully";
            request.getSession().setAttribute("message",message);

    
            response.sendRedirect(request.getContextPath() + "/books");
        }

        // Cari buku berdasarkan ID
       

    }
}
