package com.twu.biblioteca.models;

public class Book {

    private String title;
    private String author;
    private Integer year;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public Book(String title, String author, Integer year) {
        this(title, year);
        this.author = author;

    }

    public String getBookTitle(){
        return this.title;
    }


    public Integer getBookYear() {
        return this.year;
    }

    public String getAuthorName() {
        return author;
    }
}
