package com.twu.biblioteca.services;

import com.twu.biblioteca.fixtures.BookFixtures;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.repositories.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private String optionScopeTitle = Content.BOOK_SCOPE;
    private String bookListOutput = "1 - Harry Potter\tJK Rowling\t1997\n" +
            "2 - Alice in Wonderland\tLewis Carroll\t1865\n";
    private String secondBookListOutput = "1 - Alice in Wonderland 2\tLewis Carroll\t1870\n" +
            "2 - Harry Potter 2\tJK Rowling\t1999\n";



    private List<Book> buildBookList() {
        Book harryPotterBook = BookFixtures.HARRY_POTTER;
        Book aliceInWonderlandBook = BookFixtures.ALICE_WONDERLAND;

        List<Book> list = new ArrayList<Book>();
        list.add(harryPotterBook);
        list.add(aliceInWonderlandBook);
        return list;
    }

    private List<Book> buildSecondBookList() {
        Book harryPotterBook = BookFixtures.HARRY_POTTER_2;
        Book aliceInWonderlandBook = BookFixtures.ALICE_WONDERLAND_2;
        List<Book> list = new ArrayList<Book>();
        list.add(aliceInWonderlandBook);
        list.add(harryPotterBook);
        return list;
    }

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
    public void testIfSetUpInstantiateBookRepositoryThroughInjection() {

        BookRepository repository = mock(BookRepository.class);
        List<Book> list = buildBookList();
        when(repository.getBookList()).thenReturn(list);

        BookService service = new BookService(repository);

        assertEquals(service.getBookList().get(0).getTitle(), list.get(0).getTitle());

    }

    @Test
    public void testIfTheServiceIsPrintingBookListCorrectly() {
        BookService service = new BookService();
        List<Book> list = this.buildBookList();
        service.printBookList(list);
        assertEquals(optionScopeTitle + bookListOutput, outContent.toString());
    }

    @Test
    public void testIfTheServiceIsPrintingSecondBookListCorrectly() {
        BookService service = new BookService();
        List<Book> list = this.buildSecondBookList();
        service.printBookList(list);
        assertEquals(optionScopeTitle + secondBookListOutput, outContent.toString());
    }

    @Test
    public void testIfRepositoryMethodIsCalledWhenCheckingOut() {
        BookRepository repository = mock(BookRepository.class);
        when(repository.getBookList()).thenReturn(this.buildBookList());
        BookService service = new BookService(repository);
        int harryPotterMenuIndex = 1;
        service.checkBookOut(harryPotterMenuIndex);
        verify(repository, times(1)).removeBookFromList(0);
    }

    @Test
    public void testIfBookIndexIsValid() {
        BookService service = new BookService();
        int invalidBookIndex = 200;
        boolean result = service.checkBookOut(invalidBookIndex);
        assertEquals(result, false);
    }
}
