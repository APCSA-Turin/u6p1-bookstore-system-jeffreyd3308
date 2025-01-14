package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentId = "99";

    // //requires one empty constructor
    private IdGenerate() {}

    //Returns the static String variable "currentId"
    public static String getCurrentId() {
        return currentId;
    }

    //Resets static String variable "currentId" back to original value, "99"
    public static void reset() {
        currentId = "99";
    }

    //Generates a new Id which causes currentId to increase by 1
    public static void generateID() {
        currentId = Integer.toString(Integer.parseInt(currentId) + 1);
    }
}