package com.smalaca.ebook.books;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.domain.Book;
import com.smalaca.ebook.domain.BookStorage;

public class BookController {
    private final BookStorage bookStorage;

    public BookController(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public Response addBook(String title, String author) {
        if (bookStorage.exists(title, author)) {
            return Response.aFailureResponse("Book already exists.");
        } else {
            bookStorage.add(title, author);
            return Response.aSuccessfuleResponse();
        }
    }

    public Response getInformationAbout(String isbn) {
        Response response = Response.aSuccessfuleResponse();
        Book book = bookStorage.searchBy(isbn);

        response.setMessage(book.asJson());

        return response;
    }
}
