package com.twu.biblioteca.unit.services;

import com.twu.biblioteca.unit.models.Book;
import com.twu.biblioteca.unit.repositories.BookRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private BookService service;
    private BookRepository repository;

    private List<Book> buildBookList() {
        Book harryPotterBook = new Book("Harry Potter", "JK Rowling", 1997);
        Book aliceInWonderlandBook = new Book("Alice in Wonderland", "Lewis Carroll", 1865);
        List<Book> list = new ArrayList<Book>();
        list.add(harryPotterBook);
        list.add(aliceInWonderlandBook);
        return list;
    }

    @Test
    public void testIfSetUpInstantiateBookRepositoryThroughInjection() {

        BookRepository repository = mock(BookRepository.class);
        List<Book> list = buildBookList();
        when(repository.getBookList()).thenReturn(list);

        BookService service = new BookService(repository);

        assertEquals(service.getBookList().get(0).getBookTitle(), list.get(0).getBookTitle());

    }

    @Test
    public void testIfTheServiceIsPrintingBookListCorrectly() {

    }
}
