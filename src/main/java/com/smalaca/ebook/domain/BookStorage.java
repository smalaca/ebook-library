package com.smalaca.ebook.domain;

public interface BookStorage {
    void add(String title, String author);

    boolean exists(String title, String author);

    Book searchBy(String isbn);
}
