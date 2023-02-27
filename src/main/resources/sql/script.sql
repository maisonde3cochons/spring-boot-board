-- create the book and book_category tables
CREATE TABLE book (
  id VARCHAR(36) NOT NULL,
  isbn VARCHAR(13) NOT NULL,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  introduce VARCHAR(1000) NOT NULL,
  UNIQUE KEY (id)
);

CREATE TABLE book_category (
  id VARCHAR(36) NOT NULL,
  category_name VARCHAR(255) NOT NULL,
  UNIQUE KEY (id)
);

-- create the join table for the book_category_books association
CREATE TABLE book_category_books (
  book_category_id VARCHAR(36) NOT NULL,
  book_id VARCHAR(36) NOT NULL,
  KEY (book_category_id),
  KEY (book_category_id, book_id)  
);

-- insert seed data into the book and book_category tables
INSERT INTO book (id, isbn, title, author, introduce) VALUES
  ('1', '123012938948234892', 'App2Container', 'Hong HK', 'not always easy to convert App 2 Container.');

INSERT INTO book_category (id, category_name) VALUES
  ('1', 'Technical Architecture');

-- insert seed data into the book_category_books join table
INSERT INTO book_category_books (book_category_id, book_id) VALUES
  ('1', '1');
