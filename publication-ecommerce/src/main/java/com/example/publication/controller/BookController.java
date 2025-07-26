package com.example.publication.controller;

import com.example.publication.entity.Book;
import com.example.publication.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepo;

    @GetMapping
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @PostMapping
    public Book add(@RequestBody Book book) {
        return bookRepo.save(book);
    }
}
