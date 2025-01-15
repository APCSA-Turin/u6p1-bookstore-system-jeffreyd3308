package com.example.project;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore(); 
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test","Author",1900, "1234", 1);
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);store.addBook(b5);
        store.removeBook(b1);
        store.removeBook(b1);

        Book[] expected = {b1,b2,b3,b4,b5};
        System.out.println(store.getBooks().length);
        store.removeBook(b1); //b1 should be removed. testing consolidation
        for (Book book : store.getBooks()) {
            System.out.println(book);
        }
        Book[] expected2 = {b2,b3,b4,b5};
        store.removeBook(b5);

        store.removeBook(b3);store.removeBook(b3);store.removeBook(b3);store.removeBook(b3);store.removeBook(b3);
        Book[] expected4 = {b2,b4};
        Book[] expected3 = {b2,b3,b4};

    }
}