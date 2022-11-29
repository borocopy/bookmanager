package com.booksmanager.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

   @Autowired
   BookController(BookService bookService) {
       this.bookService = bookService;
   }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book) {
       bookService.addNewBook(book);
       return book;
    }

    @GetMapping(path = "/{bookId}")
    public Book getBookById(@PathVariable String bookId) {
       Long id = Long.parseLong(bookId);
       Book bookById = bookService.getBookById(id);
       return bookById;
    }

    @PutMapping(path = "/{bookId}")
    public Book updateBookById(@PathVariable String bookId,
                               @RequestBody Book newBook) {
       Long id = Long.parseLong(bookId);
       return bookService.updateBookById(id, newBook);
    }
}
