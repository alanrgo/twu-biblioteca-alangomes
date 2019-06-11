package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class BookRepository {

    private List<Book> list;

    public BookRepository() {
        list = new ArrayList<Book>();

        list.add(Book.builder()
                    .title("Harry Potter")
                    .author("JK Rowling")
                    .year(1997)
                    .build());

        list.add(Book.builder()
                    .title("Alice in Wonderland")
                    .author("Lewis Carroll")
                    .year(1865)
                    .build());
    }

    public List<Book> getBookList() {
        return list;
    }

    public boolean removeBookFromList(int bookIndex) {
        list.remove(bookIndex);
        return true;
    }
}
