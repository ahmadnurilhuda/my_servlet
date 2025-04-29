package com.greenacademy.service;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.greenacademy.models.Book;

public class BookService {

    private ArrayList<Book> listBooks = new ArrayList<Book>();
    private HttpServletRequest request;

    // Constractor
    public BookService(HttpServletRequest request) {

        this.request = request;
        this.listBooks = (ArrayList<Book>) request.getSession().getAttribute("listBooks");

    }

    public ArrayList<Book> getBook() {
        // ? kondisi awal arraylistnya null
        return listBooks == null ? new ArrayList<Book>() : this.listBooks;
    }

    public void addBook(Book book) {
        
        ArrayList<Book> listBooks = this.getBook();
        listBooks.add(book);
        // ? Simpan Kembali arraylist dalam session
        this.request.getSession().setAttribute("listBooks", listBooks);

    }

    public void updateBook(Book updateBook) {
        for (Book book : this.listBooks) {
            if (book.getId().equals(updateBook.getId())) {
                book.setTitle(updateBook.getTitle());
                book.setIsbn(updateBook.getIsbn());
                book.setYear(updateBook.getYear());
                book.setPrice(updateBook.getPrice());
                book.setStock(updateBook.getStock());
                book.setCategory(updateBook.getCategory());
                book.setDescription(updateBook.getDescription());
            }
        }
    }

    public Book getBookById(String bookId) {
        for (Book book : this.listBooks) {
            if (bookId.equals(book.getId())) {
                return book;
            }
        }
        return null;
    }

    public void deleteBook(String id) {
        if (listBooks != null) {
            for (int book = 0; book < listBooks.size(); book++) {
                if (listBooks.get(book).getId().equals(id)) {
                    listBooks.remove(book);
                }
            }
            this.request.getSession().setAttribute("listBooks", listBooks);
        }
    }
}
