package com.twu.biblioteca.repositories;
import com.twu.biblioteca.fixtures.BookFixtures;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    @Test
    public void testIfItIsReturningSingleBook() {
        BookRepository repository = new BookRepository();
        assertEquals(repository.getBookList().get(0).getTitle(), BookFixtures.HARRY_POTTER.getTitle());
    }

    @Test
    public void testIfItIsReturningMoreThanOneBook() {
        BookRepository repository = new BookRepository();

        assertEquals(repository.getBookList().get(0).getTitle(), BookFixtures.HARRY_POTTER.getTitle());
        assertEquals(repository.getBookList().get(1).getTitle(), BookFixtures.ALICE_WONDERLAND.getTitle());
    }

    @Test
    public void testIfRepositoryBooksHasAddedFields() {
        BookRepository repository = new BookRepository();
        assertEquals(repository.getBookList().get(0), BookFixtures.HARRY_POTTER);
        assertEquals(repository.getBookList().get(1), BookFixtures.ALICE_WONDERLAND);

    }
}
