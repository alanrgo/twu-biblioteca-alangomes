package com.twu.biblioteca.builders;

import com.twu.biblioteca.models.Book;

public class BookBuilder {

    private String title;
    private String author;
    private int year;

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder year(int year) {
        this.year = year;
        return this;
    }

    public Book build() {
        return new Book(title, author, year);
    }
}
