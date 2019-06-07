package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookRepository;
import com.twu.biblioteca.services.BookService;

import java.util.List;
import java.util.ListIterator;

public class BibliotecaApp {

    private BookService bookService;

    public void setBookServiceDependency(BookService service) {
        this.bookService = service;
    }

    private void printBookList(List<Book> list) {
        int i = 1;
        ListIterator<Book> bookIterator = list.listIterator();
        while(bookIterator.hasNext()) {
            System.out.print(i + " - " + bookIterator.next().getBookTitle() + "\n");
            i++;
        }
    }

    public void run() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        this.bookService.setBookRepositoryDependency(new BookRepository());
        List<Book> result = this.bookService.getBookList();
        this.printBookList(result);
    }


    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.setBookServiceDependency(new BookService());
        app.run();
    }
}
