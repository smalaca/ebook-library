package com.smalaca.ebook.domain;

public class FileBookReaderAdapter implements BookStorage {
    private final FileBookReader fileBookReader;

    public FileBookReaderAdapter(FileBookReader fileBookReader) {
        this.fileBookReader = fileBookReader;
    }

    @Override
    public void add(String title, String author) {
        fileBookReader.addBookToFile(title, author);
    }

    @Override
    public boolean exists(String title, String author) {
        return fileBookReader.existsBookInStorage(title, author);
    }

    @Override
    public Book searchBy(String isbn) {
        return fileBookReader.searchInFileBy(isbn);
    }
}
