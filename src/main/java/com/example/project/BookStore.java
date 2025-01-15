package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[5];
    private User[] users = new User[10];

    //requires 1 empty constructor
    public BookStore() {}

    //getter methods to get the attributes
    public User[] getUsers() {
        return users;
    }

    public Book[] getBooks() {
        return books;
    }

    //setter methods to set the attributes
    public void setUsers(User[] newUsers) {
        users = newUsers;
    }

    // adds an user to the first empty user index
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
    }

    //removes a specified user from the list
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                users[i] = null;
            }
        }
        consolidateUsers();
    }

    //moves every non empty user element to the front
    public void consolidateUsers() {
        int firstNull = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null && firstNull == 0) {
                firstNull = i;
            }
            if (users[i] != null && i != 0) {
                users[firstNull] = users[i];
                users[i] = null;
                firstNull++;
            }
        }
    }

    // adds a book to the first empty book index
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    // inserts a book to a specified index
    public void insertBook(Book book, int index) {
        if (books[index] != null) {
            for (int i = index; i < books.length - 1; i++) {
                books[i + 1] = books[i];
            }
            books[index] = book;
        } else {
            books[index] = book;
        }
        
    }

    //removes a specified book from the list
    public void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                if (books[i].getQuantity() > 0) {
                    books[i].setQuantity(books[i].getQuantity() - 1);
                } 
                if (books[i].getQuantity() <= 0) {
                    books[i] = null;
                    Book[] temp = new Book[books.length - 1];
                    int index = 0;
                    for (int j = 0; j < books.length; j++) {
                        if (books[j] != null) {
                            temp[index] = books[j];
                            index++;
                        }
                    }
                    books = temp;
                }
            }
        }
    }
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}