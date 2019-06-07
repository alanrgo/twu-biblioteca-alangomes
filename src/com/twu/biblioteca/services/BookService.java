package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository repository;

    public List<Book> getBookList() {
        List<Book> bookList = this.repository.getBookList();
        return bookList;
    }

    public void setBookRepositoryDependency(BookRepository repository) {
        this.repository = repository;
    }
}
