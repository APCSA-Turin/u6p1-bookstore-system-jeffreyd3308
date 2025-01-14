package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    //getter methods to get the attributes
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    //setter methods to set the attributes to a designated value
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //returns information about every detail in the book in a format
    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
       
}