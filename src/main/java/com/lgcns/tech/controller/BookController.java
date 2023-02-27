package com.lgcns.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.tech.model.Book;
import com.lgcns.tech.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
    	System.out.println(">>>>>>>>>>>>>>>>>ADDED>>>>>>>>>>>>>");
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String searchKeyword) {
        return bookService.searchBooks(searchKeyword);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/{bookId}")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Book updateBook(@PathVariable String bookId, @RequestBody Book updatedBook) {
        return bookService.updateBook(bookId, updatedBook);
    }

    @DeleteMapping("/{bookId}")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookId) {
    	System.out.println("test123");

        if (bookService.deleteBook(bookId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
