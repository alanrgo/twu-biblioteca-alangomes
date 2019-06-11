package com.twu.biblioteca.fixtures;

import com.twu.biblioteca.models.Book;

public class BookFixtures {

    public static final Book HARRY_POTTER = Book.builder()
            .title("Harry Potter")
            .author("JK Rowling")
            .year(1997)
            .build();

    public static final Book HARRY_POTTER_2 = Book.builder()
            .title("Harry Potter 2")
            .author("JK Rowling")
            .year(1999)
            .build();

    public static final Book ALICE_WONDERLAND = Book.builder()
            .title("Alice in Wonderland")
            .author("Lewis Carroll")
            .year(1865)
            .build();

    public static final Book ALICE_WONDERLAND_2 = Book.builder()
            .title("Alice in Wonderland 2")
            .author("Lewis Carroll")
            .year(1870)
            .build();
}
