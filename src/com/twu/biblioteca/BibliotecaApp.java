package com.twu.biblioteca;

import com.twu.biblioteca.services.BookService;

public class BibliotecaApp {

    private BookService bookService;

    public void setUp(BookService bookService) {
        if( bookService != null ) {
            this.bookService = bookService;
        } else {
            this.bookService = new BookService();
        }
    }

    public void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        String result = this.bookService.getBookList();
        System.out.println(result);
    }
}
