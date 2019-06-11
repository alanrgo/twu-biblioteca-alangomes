package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    String title = "Any Book Title";
    String author = "Any Author";
    Integer year = 1999;

    @Test
    public void testIfGetterGetsRightTitle() {
        Book book = Book.builder().title(title).build();
        assertEquals(book.getTitle(), title);
    }

    @Test
    public void testIfGetterGetsYear() {
        Book book = Book.builder().title(title).year(year).build();
        assertEquals(book.getYear(), year);
    }

    @Test
    public void testIfGetterGetsAuthor() {
        Book book = new Book(title, author, year);
        assertEquals(book.getAuthor(), author);
    }
}
