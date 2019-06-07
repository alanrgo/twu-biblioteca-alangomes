package com.twu.biblioteca.models;

public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getBookTitle(){
        return this.title;
    }
}
