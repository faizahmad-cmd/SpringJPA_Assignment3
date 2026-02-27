package com.assignment.Springdatajpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    // Bidirectional One-to-Many (Many books → One author)
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Many-to-Many mapping
    @ManyToMany(mappedBy = "manyToManyBooks")
    private List<Author> authors = new ArrayList<>();

    public Book() {}

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
