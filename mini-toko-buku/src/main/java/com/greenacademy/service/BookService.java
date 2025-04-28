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
    public void updateBook(Book updateBook){
        for (Book book : this.listBooks) {
            if(book.getId().equals(updateBook.getId())){
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

    public Book getBookById(String id){
        for(Book book : this.listBooks){
            if(id.equals(book.getId())){
                return book;
            }
        }
        return null;
    }
    public void deleteBook(Book book){
        System.out.println("Delete Book :"+ book.getTitle());
    }

}
