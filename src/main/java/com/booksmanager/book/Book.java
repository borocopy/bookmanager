package com.booksmanager.book;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String title;
    private String author;
    private Boolean isRead;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isRead = false;
    }

    public Book(String title, String author, Boolean isRead) {
        this.title = title;
        this.author = author;
        this.isRead = isRead;
    }

    public Book(Long id, String title, String author, Boolean isRead) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isRead = isRead;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}

