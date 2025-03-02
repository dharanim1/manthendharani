package com.onlinebookshop.shop.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.service.BookService;

@Controller
@RequestMapping("/api")
public class BookController {
	private BookService bookService;
	@GetMapping("/books")
	@ResponseBody
	public List<Book> fetchBooks(){
		return bookService.getAllBooks();
	}
		@GetMapping("/books")
		public String showBooks() {
			return "redirect:/books.html";
		}
		
	
	

}
