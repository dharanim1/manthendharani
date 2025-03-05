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
 
import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.service.AuthorService;
 
@Controller
@RequestMapping("/api")
public class AuthorController {
 
    private final AuthorService authorService;
 
    // Constructor-based dependency injection
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
 
    // Endpoint to fetch all authors
    @GetMapping("/authors")
    @ResponseBody
    public List<Author> fetchAuthors() {
        return authorService.getAllAuthors();
    }
 
    
    @GetMapping("/authors-view")
    public String showAuthors() {
        return "redirect:/authors.html";
    }
 
 
    // Endpoint to fetch an author by their ID
    @GetMapping("/authors/{id}")
    @ResponseBody
    public Author fetchAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }
 
    // Endpoint to add a new author
    @PostMapping("/authors")
    @ResponseBody
    public String addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return "Author added successfully.";
    }
 
    // Endpoint to update an author
    @PutMapping("/authors")
    @ResponseBody
    public ResponseEntity<String> updateAuthor(@RequestBody Author updatedAuthor) {
        try {
            int rowsAffected = authorService.updateAuthor(updatedAuthor);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Author updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating author.");
        }
    }
 
    // Endpoint to delete an author by their ID
    @DeleteMapping("/authors/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        try {
            int rowsAffected = authorService.deleteAuthor(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Author deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting author.");
        }
    }
}