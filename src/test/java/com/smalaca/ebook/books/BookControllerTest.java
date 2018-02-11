package com.smalaca.ebook.books;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.domain.Book;
import com.smalaca.ebook.domain.BookStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BookControllerTest {
    @Test
    public void shouldAddBook() {
        String title = "Kamasutra";
        String author = "Vatsyayana";
        BookStorage bookStorage = mock(BookStorage.class);
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.addBook(title, author);

        assertTrue(response.isSuccess());
        verify(bookStorage).add(title, author);
    }

    @Test
    public void shouldNotAddBookWhenExists() {
        String title = "Kamasutra";
        String author = "Vatsyayana";
        BookStorage bookStorage = mock(BookStorage.class);
        given(bookStorage.exists(title, author)).willReturn(true);
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.addBook(title, author);

        assertFalse(response.isSuccess());
        assertEquals("Book already exists.", response.getMessage());
        verify(bookStorage, never()).add(title, author);
    }

    @Test
    public void shouldReturnInformationAboutExistingBook() {
        String title = "Kamasutra";
        String author = "Vatsyayana";
        String isbn = "13:69:07";
        BookStorage bookStorage = mock(BookStorage.class);
        given(bookStorage.searchBy(isbn)).willReturn(new Book(title, author, isbn));
        BookController bookController = new BookController(bookStorage);

        Response response = bookController.getInformationAbout(isbn);

        assertTrue(response.isSuccess());
        assertEquals(anExpectedInformation(isbn, title, author), response.getMessage());
    }

    private String anExpectedInformation(String isbn, String title, String author) {
        return "{" +
                    "isbn:" + isbn + "," +
                    "title:" + title + "," +
                    "author:" + author +
                "}";
    }
}
