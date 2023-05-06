package com.example.bookstorebackend.repository;
import com.example.bookstorebackend.entity.Book;
import org.jetbrains.annotations.NotNull;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Book getByTitle(String title);
    Optional<Book> findBookByAuthor(String author);
    Book getBookByAuthor(String author);
    Book getBookById(Long id);
}
