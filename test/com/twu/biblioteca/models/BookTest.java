package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    String title = "Any Book Title";
    String author = "Any Author";
    Integer year = 1999;

    @Test
    public void testIfGetterGetsRightTitle() {
        Book book = new Book(title);
        assertEquals(book.getBookTitle(), title);
    }

    @Test
    public void testIfGetterGetsYear() {
        Book book = new Book(title, year);
        assertEquals(book.getBookYear(), year);
    }

    @Test
    public void testIfGetterGetsAuthor() {
        Book book = new Book(title, author, year);
        assertEquals(book.getAuthorName(), author);
    }
}
