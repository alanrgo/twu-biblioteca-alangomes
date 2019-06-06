package com.twu.biblioteca;

import com.twu.biblioteca.services.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Mock
    private BookService service;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testIfWelcomeMessageAppears() {
        BibliotecaApp app = new BibliotecaApp();

        app.setUp(null);
        app.main(null);
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }
    
    @Test
    public void testIfBookServiceIsCalled() {
        BibliotecaApp app = new BibliotecaApp();
        BookService service = mock(BookService.class);
        when(service.getBookList()).thenReturn("booklist");

        app.setUp(service);
        app.main(null);
        assertEquals("booklist", outContent.toString());
    }
}
