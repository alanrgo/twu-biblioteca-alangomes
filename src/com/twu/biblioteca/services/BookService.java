package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookRepository;

import java.util.List;
import java.util.ListIterator;

public class BookService {

    private BookRepository repository;

    public BookService() {
        this.repository = new BookRepository();
    }

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getBookList() {
        List<Book> bookList = this.repository.getBookList();
        return bookList;
    }

    public void printBookList(List<Book> list) {
        int i = 1;
        ListIterator<Book> bookIterator = list.listIterator();
        Book aux;

        System.out.print(Content.BOOK_SCOPE);
        while(bookIterator.hasNext()) {
            aux = bookIterator.next();
            System.out.print(i + " - " + aux.toString() + "\n");
            i++;
        }
    }

    public boolean checkBookOut(int menuBookIndex) {
        if( menuBookIndex > 0 && menuBookIndex <= getBookList().size()) {
            Book checkedOut = repository.removeBookFromList(menuBookIndex - 1);
            repository.insertBookIntoCheckoutList(checkedOut);
            return true;
        }
        return false;
    }

    public boolean returnBookToRegularList(int bookIndex) {
        if(  bookIndex > 0 && bookIndex <= getCheckoutList().size() ) {
            Book returnedBook = repository.removeBookFromCheckoutList(bookIndex - 1);
            repository.insertBookIntoList(returnedBook);
            return true;
        }
        return false;
    }

    public List<Book> getCheckoutList() {
        return repository.getAllCheckoutBooks();
    }
}
