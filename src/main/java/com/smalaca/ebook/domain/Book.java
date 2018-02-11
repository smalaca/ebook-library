package com.smalaca.ebook.domain;

import static java.lang.String.format;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String asJson() {
        return format("{isbn:%s,title:%s,author:%s}", isbn, title, author);
    }
}
