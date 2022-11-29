package com.booksmanager.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) throws BookAlreadyExistsException {
        Optional<Book> bookByTitleAndAuthor = bookRepository.findBookByTitleAndAuthor(
                book.getTitle(), book.getAuthor()
        );

        if (bookByTitleAndAuthor.isPresent()) {
            throw new BookAlreadyExistsException(book.getTitle(), book.getAuthor());
        }

        bookRepository.save(book);
    }

    public Book getBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> bookById = bookRepository.findById(bookId);
        if (bookById.isEmpty()) {
            throw new BookNotFoundException(bookId.toString());
        }
        return bookById.get();
    }

    @Transactional
    public Book updateBookById(Long bookId, Book newBook) {
        Book bookById = getBookById(bookId);
        if (
                bookRepository
                        .findBookByTitleAndAuthor(newBook.getTitle(), newBook.getAuthor())
                        .isPresent()
        ) {
            throw new BookAlreadyExistsException(newBook.getTitle(), newBook.getAuthor());
        }

        if (!(newBook.getTitle().isEmpty() || newBook.getTitle().isBlank())) {
            bookById.setTitle(newBook.getTitle());
        }

        if (!(newBook.getAuthor().isEmpty() || newBook.getAuthor().isBlank())) {
            bookById.setAuthor(newBook.getAuthor());
        }

        bookById.setRead(newBook.getRead());

        return bookById;
    }
}
