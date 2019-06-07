package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class BookRepository {

    public List<Book> getBookList() {
        List<Book> list = new ArrayList<Book>();
        list.add(new Book("Harry Potter", "JK Rowling", 1997));
        list.add(new Book("Alice in Wonderland", "Lewis Carroll", 1865));
        return list;
    }
}
