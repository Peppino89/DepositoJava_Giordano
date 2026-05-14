package org.example.eserciziocatalogolibri.controller;

import org.example.eserciziocatalogolibri.model.Book;
import org.example.eserciziocatalogolibri.model.Genre;
import org.example.eserciziocatalogolibri.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // Recupera Tutti i libri
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(repository.findAll());
    }

    // Recupera Libro tramite l'ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crea un libro
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        Book savedBook = repository.save(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedBook);
    }

    // Aggiorna un libro
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id,
                                           @RequestBody Book updatedBook) {

        return repository.findById(id)
                .map(book -> {

                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPages(updatedBook.getPages());
                    book.setGenre(updatedBook.getGenre());

                    Book savedBook = repository.save(book);

                    return ResponseEntity.ok(savedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Rimuovi un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // Trova in base all'autore
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {

        return ResponseEntity.ok(repository.findByAuthor(author));
    }

    // Trova in base all genere
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable Genre genre) {

        return ResponseEntity.ok(repository.findByGenre(genre));
    }

    //cerca un libro qualsiasi
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String keyword) {

        return ResponseEntity.ok(repository.findByTitleContaining(keyword));
    }
}
