package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book[] book that is initialized to empty
    private String name;
    private String Id;
    private Book[] book;

    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
        book = new Book[5];
    }

    //getter methods to get the attributes
    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    public Book[] getBooks() {
        return book;
    }

    //setter methods to set the attributes to a designated value
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setBooks(Book[] newBook) {
        book = newBook;
    }

    //returns a list of books that the user has
    public String bookListInfo() {
        String str = "";
        for (Book singularBook : book) {
            if (singularBook == null) {
                str += "empty\n";
            } else {
                str += singularBook.bookInfo() + "\n";
            }
        }
        return str;
    }

    // public String userInfo(){} //returns  "Name: []\nID: []\nBooks:\n[]"
    //returns the user info of their name, id, and books
    public String userInfo() {
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
    }
       
}