package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.MenuOption;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.Content;
import com.twu.biblioteca.services.MenuService;
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

    private String welcomeMessage = Content.WELCOME_MESSAGE;
    private String bookScopeTitle = Content.BOOK_SCOPE;
    private String quitMessage = Content.QUIT_MESSAGE;
    private String menuStringfied = Content.STRINGIFIED_MENU;

    private String strinfiedBookList = "1 - Harry Potter\tJK Rowling\t1997\n" +
            "2 - Alice in Wonderland\tLewis Carroll\t1865\n";


    private String output = welcomeMessage + quitMessage;
    private BookService bookService;
    private MenuService menuService;

    private String functionalOutput = welcomeMessage + menuStringfied + quitMessage;

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
        when(this.menuService.getUserOption())
                .thenReturn(MenuOption.LIST_BOOKS)
                .thenReturn(MenuOption.QUIT);
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
    public void testIfMenuIsCalled() {
        BibliotecaApp app = new BibliotecaApp(this.bookService, this.menuService);
        app.run();
        verify(this.menuService, times(2)).displayMenu();
    }

    @Test
    public void testIfMenuIsDisplayed() {
        doCallRealMethod().when(this.menuService).displayMenu();
        when(this.menuService.getUserOption())
                .thenReturn(MenuOption.QUIT);
        BibliotecaApp app = new BibliotecaApp(new BookService(), this.menuService);
        app.run();
        assertEquals(functionalOutput, outContent.toString());
    }

    @Test
    public void testIfUserInputIsInserted() {
        BibliotecaApp app = new BibliotecaApp(this.bookService, this.menuService);
        app.run();
        verify(this.menuService, times(2)).getUserOption();
    }

    @Test
    public void testIfBookListIsDisplayedIfOptionIs1() {
        this.menuService = mock(MenuService.class);
        doCallRealMethod().when(this.menuService).displayMenu();
        when(this.menuService.getUserOption())
                .thenReturn(MenuOption.LIST_BOOKS)
                .thenReturn(MenuOption.QUIT);
        BibliotecaApp app = new BibliotecaApp(new BookService(), this.menuService);
        app.run();
        assertEquals(
                welcomeMessage
                        + menuStringfied + bookScopeTitle + strinfiedBookList
                        + menuStringfied + quitMessage
                , outContent.toString());
    }

    @Test
    public void testIfTheApplicationIsFinishing() {
        this.menuService = mock(MenuService.class);
        doCallRealMethod().when(this.menuService).displayMenu();
        when(this.menuService.getUserOption()).thenReturn(MenuOption.QUIT);
        BibliotecaApp app = new BibliotecaApp(new BookService(), this.menuService);
        app.run();
        assertEquals(functionalOutput, outContent.toString());
    }

    @Test
    public void testIfProgramOnlyFinishesAfterQuitOption() {
        this.menuService = mock(MenuService.class);
        doCallRealMethod().when(this.menuService).displayMenu();
        when(this.menuService.getUserOption())
                .thenReturn(MenuOption.LIST_BOOKS)
                .thenReturn(MenuOption.LIST_BOOKS)
                .thenReturn(MenuOption.QUIT);

        BibliotecaApp app = new BibliotecaApp(new BookService(), this.menuService);
        app.run();

        assertEquals(welcomeMessage
                + menuStringfied + bookScopeTitle + strinfiedBookList
                + menuStringfied + bookScopeTitle + strinfiedBookList
                + menuStringfied + quitMessage, outContent.toString());
    }

}
