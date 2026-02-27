package com.assignment.Springdatajpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Embedded Address
    @Embedded
    private Address address;

    // List of subjects
    @ElementCollection
    @CollectionTable(
        name = "author_subjects",
        joinColumns = @JoinColumn(name = "author_id")
    )
    @Column(name = "subject")
    private List<String> subjects = new ArrayList<>();


    // One-to-One mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "one_to_one_book_id")
    private Book oneToOneBook;


    // Unidirectional One-to-Many (No additional table)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uni_author_id")
    private List<Book> uniDirectionalBooks = new ArrayList<>();


    // Bidirectional One-to-Many
    @OneToMany(
        mappedBy = "author",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Book> biDirectionalBooks = new ArrayList<>();


    // Many-to-Many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "author_book_many_to_many",
        joinColumns = @JoinColumn(name = "author_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> manyToManyBooks = new ArrayList<>();


    public Author() {}

    public Author(String name, Address address) {
        this.name = name;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }


    public Book getOneToOneBook() {
        return oneToOneBook;
    }

    public void setOneToOneBook(Book oneToOneBook) {
        this.oneToOneBook = oneToOneBook;
    }


    public List<Book> getUniDirectionalBooks() {
        return uniDirectionalBooks;
    }

    public void setUniDirectionalBooks(List<Book> uniDirectionalBooks) {
        this.uniDirectionalBooks = uniDirectionalBooks;
    }


    public List<Book> getBiDirectionalBooks() {
        return biDirectionalBooks;
    }

    public void setBiDirectionalBooks(List<Book> biDirectionalBooks) {
        this.biDirectionalBooks = biDirectionalBooks;
    }


    public List<Book> getManyToManyBooks() {
        return manyToManyBooks;
    }

    public void setManyToManyBooks(List<Book> manyToManyBooks) {
        this.manyToManyBooks = manyToManyBooks;
    }
}