package com.lgcns.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.tech.model.BookCategory;


@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, String>{
	List<BookCategory> findByCategoryName(String categoryName);

}
