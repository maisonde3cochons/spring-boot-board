package com.lgcns.tech.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "book")
public class Book {

    @Id
    private String id;

    private String isbn;

    private String title;

    private String author;

    private String introduce;
    
    
    
	public Book() {
	}

	public Book(String id, String isbn, String title, String author, String introduce ) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.introduce = introduce;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}
