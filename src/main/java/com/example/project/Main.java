package com.example.project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = -1;
        BookStore store = new BookStore();
        System.out.println("**Welcome to the APSCA Library****");
        System.out.println("Select from the following options:");
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Press 0 to exit application");
        System.out.println("Press 1 to add a book");
        System.out.println("Press 2 to update quantity of book");
        System.out.println("Press 3 to search a book");
        System.out.println("Press 4 to show all books");
        System.out.println("Press 5 to register student");
        System.out.println("Press 6 to show all registered students");
        System.out.println("Press 7 to check out book");
        System.out.println("Press 8 to check in book");
        System.out.println("----------------------------------");
        while (answer != 0) {
            System.out.println("----------------------------------");
            System.out.println("Press 0 to exit application");
            System.out.println("Press 1 to add a book");
            System.out.println("Press 2 to update quantity of book");
            System.out.println("Press 3 to search a book");
            System.out.println("Press 4 to show all books");
            System.out.println("Press 5 to register student");
            System.out.println("Press 6 to show all registered students");
            System.out.println("Press 7 to check out book");
            System.out.println("Press 8 to check in book");
            System.out.println("----------------------------------");
            answer = scan.nextInt();
            switch (answer) {
                case 1:
                    System.out.println("Enter serial number of book");
                    String isbn = scan.next();
                    System.out.println("Enter name of book");
                    String name = scan.next();
                    System.out.println("Enter year of publication for book");
                    int year = scan.nextInt();
                    System.out.println("Enter the author of the book");
                    String author = scan.next();
                    System.out.println("Enter quantity of book");
                    int quantity = scan.nextInt();
                    store.addBook(new Book(name, author, year, isbn, quantity));
                    break;
                case 2:
                    System.out.println("Enter a book name");
                    String bookName = scan.next();
                    System.out.println("Enter a new quantity");
                    int newQuantity = scan.nextInt();
                    boolean isIn = false;
                    for (int i = 0; i < store.getBooks().length; i++) {
                        if (store.getBooks()[i] != null && store.getBooks()[i].getTitle().equals(bookName)) {
                            store.getBooks()[i].setQuantity(newQuantity);
                            isIn = true;
                        }
                    }
                    if (isIn) {
                        System.out.println("Quantity successfully updated");
                    } else {
                        System.out.println("Book not in store");
                    }
                    break;
                case 3:
                    System.out.println("Enter a book name");
                    String searchName = scan.next();
                    boolean searchable = false;
                    for (int i = 0; i < store.getBooks().length; i++) {
                        if (store.getBooks()[i] != null && store.getBooks()[i].getTitle().equals(searchName)) {
                            searchable = true;
                            System.out.println(store.getBooks()[i].bookInfo());
                        }
                    }
                    if (!searchable) {
                        System.out.println("Book not in store");
                    }
                    break;
                case 4:
                    for (int i = 0; i < store.getBooks().length; i++) {
                        if (store.getBooks()[i] != null) {
                            System.out.println(store.getBooks()[i].bookInfo());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter student name");
                    String studentName = scan.next();
                    System.out.println("Enter student ID");
                    String Id = scan.next();
                    store.addUser(new User(studentName, Id));
                    break;
                case 6:
                    for (int i = 0; i < store.getUsers().length; i++) {
                        if (store.getUsers()[i] != null) {
                            System.out.println(store.getUsers()[i].userInfo());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Enter a student's name");
                    String selectedName = scan.next();
                    for (int i = 0; i < store.getUsers().length; i++) {
                        if (store.getUsers()[i] != null && store.getUsers()[i].getName().equals(selectedName)) {
                            Book[] currentList = store.getUsers()[i].getBooks();
                            System.out.println("Enter a book name");
                            String selectedBookName = scan.next();
                            for (int j = 0; j < store.getBooks().length; j++) {
                                if (store.getBooks()[j] != null && store.getBooks()[j].getTitle().equals(selectedBookName)) {
                                    store.getBooks()[j].setQuantity(store.getBooks()[j].getQuantity() - 1);
                                    for (int k = 0; k < currentList.length; i++) {
                                        if (currentList[k] == null) {
                                            currentList[k] = store.getBooks()[j];
                                            break;
                                        }
                                    }
                                    store.getUsers()[i].setBooks(currentList);
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("Enter a student's name");
                    String selectedStudentName = scan.next();
                    for (int i = 0; i < store.getUsers().length; i++) {
                        if (store.getUsers()[i] != null && store.getUsers()[i].getName().equals(selectedStudentName)) {
                            Book[] currentList = store.getUsers()[i].getBooks();
                            System.out.println("Enter a book name");
                            String selectedBookName = scan.next();
                            for (int j = 0; j < store.getBooks().length; j++) {
                                if (store.getBooks()[j] != null && store.getBooks()[j].getTitle().equals(selectedBookName)) {
                                    store.getBooks()[j].setQuantity(store.getBooks()[j].getQuantity() + 1);
                                    for (int k = 0; k < currentList.length; i++) {
                                        if (currentList[k] != null && currentList[k].getTitle().equals(selectedBookName)) {
                                            currentList[k] = null;
                                            break;
                                        }
                                    }
                                    store.getUsers()[i].setBooks(currentList);
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
}