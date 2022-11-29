package com.booksmanager.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String bookId) {
        super(String.format("Book with id %s is not found", bookId));
    }
}
