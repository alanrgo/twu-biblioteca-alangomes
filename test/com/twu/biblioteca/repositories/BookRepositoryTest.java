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
}
