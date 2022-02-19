package com.gleenpeltroche.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gleenpeltroche.books.models.Book;
import com.gleenpeltroche.books.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookservice;
	
	@RequestMapping("/books/{id}")
	public String index(Model model, @PathVariable("id") Long id) {
		Book book = bookservice.findBook(id);
		model.addAttribute("book", book);
        return "index.jsp";
    }
}
