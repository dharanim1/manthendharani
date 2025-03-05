package com.onlinebookshop.shop.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.service.BookService;

@Controller
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    // Constructor-based dependency injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Endpoint to fetch all books
    @GetMapping("/books")
    @ResponseBody
    public List<Book> fetchBooks() {
        return bookService.getAllBooks();
    }

    // Endpoint to redirect to books.html
    @GetMapping
    public String showBooks() {
        return "redirect:/books.html";
    }

    // Endpoint to fetch a book by its ID
    @GetMapping("/books/{id}")
    @ResponseBody
    public Book fetchBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // Endpoint to add a new book
    @PostMapping("/books")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully.";
    }

    // Endpoint to delete a book by its ID
    @DeleteMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        try {
            int rowsAffected = bookService.deleteBook(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Book deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting book");
        }
    }

    // Endpoint to update a book by its ID
    @PutMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        try {
            Book existingBook = bookService.getBookById(id);
            if (existingBook != null) {
                existingBook.settitle(updatedBook.gettitle());
                existingBook.setPrice(updatedBook.getPrice());
                existingBook.setAuthorId(updatedBook.getAuthorId());
                bookService.updateBook(existingBook);
                return ResponseEntity.ok(existingBook);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
