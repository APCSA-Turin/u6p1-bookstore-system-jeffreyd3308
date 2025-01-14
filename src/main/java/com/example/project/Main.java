package com.example.project;

public class Main {
    public static void main(String[] args) {
        IdGenerate.reset(); //reset for test
        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        System.out.println(u1.userInfo());
        if (u1.userInfo().equals("Name: John\nId: 100\nBooks: \nempty\nempty\nempty\nempty\nempty\n")) {
            System.out.println("true");
        }
    }
}