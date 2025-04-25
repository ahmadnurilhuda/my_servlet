package com.greenacademy.models;

import java.time.LocalDate;

public class Book {
    
    private String title;
    private String isbn;
    private LocalDate year;
    private double price;
    private int stock;
    

    public Book(String title, double price, int stock, String isbn, LocalDate year) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public LocalDate getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
}
