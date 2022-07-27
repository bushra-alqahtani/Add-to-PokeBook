package com.codingdojo.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller

public class BookController {
	//dependency injection 
	@Autowired
	BookService bookService;
	

	
	//create the book
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "pokebook.jsp";
    }
    @RequestMapping(value="/books/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {  // for Error checking i use @valid 
        if (result.hasErrors()) {
           return "pokebook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/all";
        }
    }
    
//	rendering information of the book in separate page 
	@RequestMapping("/all")
	public String allBooks(Model model) {
		List<Book> allbooks=bookService.getAllBooks();
		model.addAttribute("allbooks", allbooks);
		return "pokebookall.jsp";
	}
	
//	rendering information of the book in separate page 
	@RequestMapping("/{bookId}")
	public String index(Model model,@PathVariable("bookId") Long bookId) {
		Book book=bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "index.jsp";
	}
    
		    
	

}
