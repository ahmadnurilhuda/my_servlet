package com.greenacademy.product;

import java.time.LocalDate;

public class Book {
    
    String title;
    String isbn;
    LocalDate year;
    double price;
    int stock;
    

    public Book(String title, double price, int stock, String isbn, LocalDate year) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.isbn = isbn;
        this.year = year;
    }
}
