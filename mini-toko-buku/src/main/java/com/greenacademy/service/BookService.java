package com.greenacademy.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.greenacademy.models.Book;

public class BookService {
    private ArrayList<Book> listBooks = new ArrayList<Book>();
    private HttpServletRequest request;

    // Constractor
    public BookService (HttpServletRequest request){

        this.request = request;
        this.listBooks = (ArrayList<Book>)request.getSession().getAttribute("listBooks");
    }

    public ArrayList<Book> getBook(){
        return listBooks == null? new ArrayList<Book>() :this.listBooks;
    }

    public void addBook(Book book){
        //? kondisi awal arraylistnya null
    ArrayList<Book> listBooks =  this.getBook();
    listBooks.add(book);
        //? Simpan Kembali arraylist dalam session
    this.request.getSession().setAttribute("listBooks", listBooks);



    }
    public void updateBook(Book book){
        System.out.println("Edit Book "+ book.getTitle());
    }
    public void deleteBook(Book book){
        System.out.println("Delete Book :"+ book.getTitle());
    }

}
