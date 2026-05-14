package org.example.eserciziocatalogolibri.repository;

import org.example.eserciziocatalogolibri.model.Book;
import org.example.eserciziocatalogolibri.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    // Ritorna tutti i libri
    List<Book>findAll();

    // trova libri per titolo esatto
    List<Book> findByTitle(String title);

    // trova libri che contengono una parola nel titolo
    List<Book> findByTitleContaining(String keyword);

    // trova libri per autore
    List<Book> findByAuthor(String author);

    // trova libri di un genere
    List<Book> findByGenre(Genre genre);

    // trova libri con più pagine di un valore
    List<Book> findByPagesGreaterThan(int pages);

    // trova libri con meno pagine di un valore
    List<Book> findByPagesLessThan(int pages);

    // trova libri ordinati per titolo
    List<Book> findAllByOrderByTitleAsc();

    // controlla se esiste un libro con un certo titolo
    boolean existsByTitle(String title);

    // conta libri di un genere
    long countByGenre(Genre genre);
}
