package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testIfGetterGetsRightTitle() {
        String bookTitle = "Harry Potter is the name of the book";
        Book book = new Book(bookTitle);
        assertEquals(book.getBookTitle(), bookTitle);
    }
}
