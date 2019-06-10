package com.twu.biblioteca.unit;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.unit.models.Book;
import com.twu.biblioteca.unit.services.BookService;
import com.twu.biblioteca.unit.services.MenuService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private String output = welcomeMessage;
    private BookService bookService;
    private MenuService menuService;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Before
    public void setUpBookServiceMock() {
        this.bookService = mock(BookService.class);
        when(this.bookService.getBookList()).thenReturn(new ArrayList<Book>());
    }

    @Before
    public void setUpMenuServiceMock() {
        this.menuService = mock(MenuService.class);
        doNothing().when(this.menuService).displayMenu();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testIfWelcomeMessageAppears() {
        BibliotecaApp app = new BibliotecaApp(this.bookService, this.menuService);

        app.run();
        assertEquals(output, outContent.toString());
    }

    
    @Test
    public void testIfBookServiceIsCalled() {

        BibliotecaApp app = new BibliotecaApp(this.bookService, this.menuService);
        app.run();
        verify(this.bookService, times(1)).getBookList();
    }

    @Test
    public void testIfMenuIsCalled() {
        BibliotecaApp app = new BibliotecaApp(this.bookService, this.menuService);
        app.run();
        verify(this.menuService, times(1)).displayMenu();
    }


}
