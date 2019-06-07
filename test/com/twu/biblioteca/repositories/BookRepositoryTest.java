package com.twu.biblioteca.repositories;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    @Test
    public void testIfItIsReturningSingleBook() {
        BookRepository repository = new BookRepository();
        String bookTitle = "Harry Potter";

        assertEquals(repository.getBookList().get(0).getBookTitle(), bookTitle);
    }

    @Test
    public void testIfItIsReturningMoreThanOneBook() {
        BookRepository repository = new BookRepository();
        String HarryPotterTitle = "Harry Potter";
        String AliceInWonderlandTitle = "Alice in Wonderland";

        assertEquals(repository.getBookList().get(0).getBookTitle(), HarryPotterTitle);
        assertEquals(repository.getBookList().get(1).getBookTitle(), AliceInWonderlandTitle);
    }

    @Test
    public void testIfRepositoryBooksHasAddedFields() {
        BookRepository repository = new BookRepository();
        String HarryPotterTitle = "Harry Potter";
        String AliceInWonderlandTitle = "Alice in Wonderland";
        Integer year1865 = 1865;
        Integer year1997 = 1997;

        assertEquals(repository.getBookList().get(0).getBookTitle(), HarryPotterTitle);
        assertEquals(repository.getBookList().get(0).getBookYear(), year1997);
        assertEquals(repository.getBookList().get(0).getAuthorName(), "JK Rowling");
        assertEquals(repository.getBookList().get(1).getBookTitle(), AliceInWonderlandTitle);
        assertEquals(repository.getBookList().get(1).getBookYear(), year1865);
        assertEquals(repository.getBookList().get(1).getAuthorName(), "Lewis Carroll");
    }
}
