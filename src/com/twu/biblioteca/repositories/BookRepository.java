package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class BookRepository {

    public List<Book> getBookList() {
        List<Book> list = new ArrayList<Book>();
        list.add(new Book("Harry Potter"));
        list.add(new Book("Alice in Wonderland"));
        return list;
    }
}
