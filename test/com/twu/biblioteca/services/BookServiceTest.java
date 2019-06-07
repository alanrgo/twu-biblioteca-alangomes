package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Test
    public void testIfSetUpInstantiateBookRepositoryThroughInjection() {
        BookService service = new BookService();

        BookRepository repository = mock(BookRepository.class);
        List<Book> list= new ArrayList<Book>();
        String harryPotterTitle = "Harry Potter";

        list.add(new Book(harryPotterTitle));

        when(repository.getBookList()).thenReturn(list);

        service.setBookRepositoryDependency(repository);
        assertEquals(service.getBookList().get(0).getBookTitle(), harryPotterTitle);


    }
}
