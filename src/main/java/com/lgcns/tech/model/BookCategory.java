package com.lgcns.tech.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "book_category")
public class BookCategory {

    @Id
    private String id;

    private String categoryName;

    @ManyToMany
    @JoinTable(name = "book_category_books",
            joinColumns = @JoinColumn(name = "book_category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    
	public BookCategory() {
	}

	public BookCategory(String id, String categoryName, List<Book> books) {
		this.id = id;
		this.categoryName = categoryName;
		this.books = books;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
}
