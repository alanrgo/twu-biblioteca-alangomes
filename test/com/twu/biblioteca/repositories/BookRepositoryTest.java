package com.twu.biblioteca.repositories;
import com.twu.biblioteca.fixtures.BookFixtures;
import com.twu.biblioteca.models.Book;
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

    @Test
    public void testIfBookIsBeingRemovedFromList() {
        BookRepository repository = new BookRepository();
        int expectedFinalSize = repository.getBookList().size() - 1;
        int bookIndex = 0;
        repository.removeBookFromList(bookIndex);
        assertEquals(expectedFinalSize, repository.getBookList().size());
    }

    @Test
    public void testIfCheckedOutBookReachesOtherList() {
        BookRepository repository = new BookRepository();
        int expectedCheckoutListSize = 1;
        int bookIndex = 0;
        Book checkedOut = repository.removeBookFromList(bookIndex);
        repository.insertBookIntoCheckoutList(checkedOut);
        assertEquals(expectedCheckoutListSize, repository.getAllCheckoutBooks().size());
    }
}
