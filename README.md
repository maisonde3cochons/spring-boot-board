# Book Management Service

The Book Management Service is a Spring Boot application that provides a RESTful API for managing books and book categories.

## Requirements

- Java 8 or higher
- Gradle 6.7.1 or higher
- Spring Boot 2.4.2 or higher
- Spring Data JPA 2.4.3 or higher
- H2 Database Engine 1.4.200 or higher

## Installation

1. Clone the repository to your local machine.

git clone https://github.com/<your-username>/spring-boot-board.git


2. Build the project using Gradle.

cd spring-boot-board
gradle build


3. Run the project using the Spring Boot Gradle plugin.

gradle bootRun



4. Navigate to http://localhost:8080/swagger-ui.html to access the Book Management Service API.

## Usage

The Book Management Service API provides the following endpoints:

### Book Endpoints

- `POST /books` - Add a new book.
- `GET /books` - Retrieve all books.
- `GET /books/search?searchKeyword={searchKeyword}` - Search for books by title or author.
- `GET /books/{bookId}` - Retrieve a book by ID.
- `PUT /books/{bookId}` - Update an existing book by ID.
- `DELETE /books/{bookId}` - Delete a book by ID.

### Book Category Endpoints

- `POST /categories` - Add a new book category.
- `GET /categories` - Retrieve all book categories.
- `GET /categories/{categoryId}` - Retrieve a book category by ID.
- `PUT /categories/{categoryId}` - Update an existing book category by ID.
- `DELETE /categories/{categoryId}` - Delete a book category by ID.
- `POST /categories/{categoryId}/books` - Add a book to a book category.
- `GET /categories/{categoryId}/books` - Retrieve all books in a book category.
- `DELETE /categories/{categoryId}/books/{bookId}` - Remove a book from a book category.

### Authentication

The Book Management Service API uses role-based access control to restrict certain endpoints to users with specific roles. The following roles are defined:

- `ROLE_USER` - Allows read-only access to book and book category data.
- `ROLE_MANAGER` - Allows full access to book and book category data.

To authenticate with the Book Management Service API, include a JWT token in the `Authorization` header of your HTTP requests. You can obtain a JWT token by sending a `POST` request to the `/auth` endpoint with valid credentials.

## License

The Book Management Service is released under the MIT License. See LICENSE for more information.

