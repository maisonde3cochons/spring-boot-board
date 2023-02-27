package com.lgcns.tech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.tech.model.Book;
import com.lgcns.tech.model.BookCategory;
import com.lgcns.tech.repository.BookCategoryRepository;
import com.lgcns.tech.repository.BookRepository;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book updateBook(String bookId, Book updatedBook) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return null;
        }

        book.setIsbn(updatedBook.getIsbn());
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIntroduce(updatedBook.getIntroduce());

        return bookRepository.save(book);
    }

    public boolean deleteBook(String bookId) {
        if (!bookRepository.existsById(bookId)) {
            return false;
        }

        bookRepository.deleteById(bookId);
        return true;
    }

    public BookCategory addCategory(BookCategory category) {
        return bookCategoryRepository.save(category);
    }

    public List<BookCategory> getAllCategories() {
        return bookCategoryRepository.findAll();
    }

    public BookCategory getCategoryById(String categoryId) {
        return bookCategoryRepository.findById(categoryId).orElse(null);
    }

    public BookCategory updateCategory(String categoryId, BookCategory updatedCategory) {
        BookCategory category = bookCategoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return null;
        }

        category.setCategoryName(updatedCategory.getCategoryName());

        return bookCategoryRepository.save(category);
    }

    public boolean deleteCategory(String categoryId) {
        if (!bookCategoryRepository.existsById(categoryId)) {
            return false;
        }

        bookCategoryRepository.deleteById(categoryId);
        return true;
    }

    public boolean addBookToCategory(String categoryId, String bookId) {
        BookCategory category = bookCategoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return false;
        }

        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return false;
        }

        category.getBooks().add(book);

        bookCategoryRepository.save(category);
        bookRepository.save(book);

        return true;
    }

    public List<Book> getBooksInCategory(String categoryId) {
        BookCategory category = bookCategoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return null;
        }

        return category.getBooks();
    }

    public boolean removeBookFromCategory(String categoryId, String bookId) {
        BookCategory category = bookCategoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return false;
        }

        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return false;
        }

        category.getBooks().remove(book);

        bookCategoryRepository.save(category);
        bookRepository.save(book);

        return true;
    }
}
