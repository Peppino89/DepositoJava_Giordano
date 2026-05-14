package org.example.eserciziocatalogolibri.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="author",nullable = false)
    private String author;

    @Column(name="pages" ,nullable = false)
    private int pages;

    @Enumerated(EnumType.STRING)
    @Column(name="genre", nullable = false)
    private Genre genre;

    protected Book(){}

    public Book(String title, String author, int pages, Genre genre) {

        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if(author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }

        if(pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0");
        }

        if(genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }


        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }

        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if(pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0");
        }
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        if(genre == null) {
            throw new IllegalArgumentException("Genre cannot be null");
        }

        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book {id: "+getId()+", title: "+getTitle()+", Author: "+getAuthor()+", Pages: "+getPages()+", Genre: "+getGenre()+"}";
    }
}
