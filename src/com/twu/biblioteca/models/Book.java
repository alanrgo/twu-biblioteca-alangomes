package com.twu.biblioteca.models;

import com.twu.biblioteca.builders.BookBuilder;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private Integer year;


    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle(){
        return this.title;
    }

    public Integer getYear() {
        return this.year;
    }

    public String getAuthor() {
        return author;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Book book = (Book) other;
        return this.getTitle().equals(book.getTitle()) &&
                this.getAuthor().equals(book.getAuthor()) &&
                this.getYear().equals(book.getYear());
    }

}
