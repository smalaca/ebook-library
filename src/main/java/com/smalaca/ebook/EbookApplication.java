package com.smalaca.ebook;

import com.smalaca.ebook.books.BookController;
import com.smalaca.ebook.domain.BookStorage;
import com.smalaca.ebook.domain.FileBookReader;
import com.smalaca.ebook.domain.FileBookReaderAdapter;
import com.smalaca.ebook.domain.UserStorage;
import com.smalaca.ebook.view.EbookView;

import java.util.Scanner;

public class EbookApplication {
    public static void main(String[] args) {
        FileBookReader fileBookReader = new FileBookReader();
        new BookController(new FileBookReaderAdapter(fileBookReader));

        new EbookView(new Scanner(System.in), new UserStorage()).show();
    }
}
