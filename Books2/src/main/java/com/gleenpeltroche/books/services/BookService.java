package com.gleenpeltroche.books.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.gleenpeltroche.books.models.Book;
import com.gleenpeltroche.books.repositories.BookRepository;
@Service
public class BookService {
 private final BookRepository bookRepository;
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }

 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 
 public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	 Book bookToUpdate = this.findBook(id);
	 bookToUpdate.setTitle(title);
	 bookToUpdate.setDescription(desc);
	 bookToUpdate.setLanguage(lang);
	 bookToUpdate.setNumberOfPages(numOfPages);
	 return bookRepository.save(bookToUpdate);
 }
 
 public void deleteBook(Long id) {
	 bookRepository.deleteById(id);
 }
 
 
}
