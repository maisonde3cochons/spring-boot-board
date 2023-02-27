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
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.tech.model.Book;
import com.lgcns.tech.model.BookCategory;
import com.lgcns.tech.service.BookCategoryService;

@RestController
@RequestMapping("/categories")
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;

    
    @Autowired
    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @PostMapping
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public BookCategory addCategory(@RequestBody BookCategory category) {
        return bookCategoryService.addCategory(category);
    }

    @GetMapping
    public List<BookCategory> getAllCategories() {
        return bookCategoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public BookCategory getCategoryById(@PathVariable String categoryId) {
        return bookCategoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public BookCategory updateCategory(@PathVariable String categoryId, @RequestBody BookCategory updatedCategory) {
        return bookCategoryService.updateCategory(categoryId, updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> deleteCategory(@PathVariable String categoryId) {
        if (bookCategoryService.deleteCategory(categoryId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{categoryId}/books")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> addBookToCategory(@PathVariable String categoryId, @RequestBody String bookId) {
        if (bookCategoryService.addBookToCategory(categoryId, bookId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{categoryId}/books")
    public List<Book> getBooksInCategory(@PathVariable String categoryId) {
        return bookCategoryService.getBooksInCategory(categoryId);
    }

    @DeleteMapping("/{categoryId}/books/{bookId}")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> removeBookFromCategory(@PathVariable String categoryId, @PathVariable String bookId) {
        if (bookCategoryService.removeBookFromCategory(categoryId, bookId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
