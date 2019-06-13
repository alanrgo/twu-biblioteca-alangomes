package com.twu.biblioteca.repositories;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class BookRepository {

    private List<Book> list;
    private List<Book> checkoutList;

    public BookRepository() {
        list = new ArrayList<Book>();
        checkoutList = new ArrayList<Book>();

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

    public Book removeBookFromList(int bookIndex) {
        Book removed = list.remove(bookIndex);
        return removed;
    }

    public void insertBookIntoCheckoutList(Book checkedOut) {
        checkoutList.add(checkedOut);
    }

    public List<Book> getAllCheckoutBooks() {
        return checkoutList;
    }

    public Book removeBookFromCheckoutList(int bookIndex) {
        Book removed = checkoutList.remove(bookIndex);
        return removed;
    }

    public void insertBookIntoList(Book bookToBeInserted) {
        list.add(bookToBeInserted);
    }
}
