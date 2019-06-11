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

        System.out.print("\nBooks in the library\n");
        while(bookIterator.hasNext()) {
            aux = bookIterator.next();
            System.out.print(i + " - " + aux.getTitle() + "\t" +
                    aux.getAuthor() + "\t" +
                    aux.getYear() +
                    "\n");
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

    public void returnBook() {
        
    }
}
