package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.services.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private String stringfiedBookList = "1 - Harry Potter and the Phylosopher Stone\n2 - Harry Potter and Askaban prisioner\n";
    private List<Book> bookList;
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private String output = welcomeMessage + stringfiedBookList;
    private BookService service;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        this.service = mock(BookService.class);
        bookList = this.setBookListUp();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testIfWelcomeMessageAppears() {
        BibliotecaApp app = new BibliotecaApp();
        when(this.service.getBookList()).thenReturn(bookList);
        app.setBookServiceDependency(this.service);
        app.run();
        assertEquals(output, outContent.toString());
    }

    private List<Book> setBookListUp() {
        List<Book> bookList = new ArrayList<Book>();

        bookList.add(new Book("Harry Potter and the Phylosopher Stone"));
        bookList.add(new Book("Harry Potter and Askaban prisioner"));
        return bookList;
    }
    
    @Test
    public void testIfBookServiceIsCalled() {
        BibliotecaApp app = new BibliotecaApp();

        when(this.service.getBookList()).thenReturn(bookList);
        app.setBookServiceDependency(this.service);
        app.run();
        assertEquals(output , outContent.toString());
    }
}
