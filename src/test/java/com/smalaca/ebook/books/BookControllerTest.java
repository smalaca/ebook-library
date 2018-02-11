package com.smalaca.ebook.books;

import com.smalaca.ebook.communication.Response;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookControllerTest {
    @Test
    public void shouldAddBook() {
        String title = "Kamasutra";
        String author = "Vatsyayana";
        BookController bookController = new BookController();

        Response response = bookController.addBook(title, author);

        assertTrue(response.isSuccess());
    }
}
