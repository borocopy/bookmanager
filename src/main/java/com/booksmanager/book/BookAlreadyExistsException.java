package com.booksmanager.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String title, String author) {
        super(String.format(
                "Book %s by %s already exists", title, author
        ));
    }
}
