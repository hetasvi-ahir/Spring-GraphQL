package com.query.service;

import java.util.List;

import com.query.entity.Book;


public interface BookService 
{
	public Book createBook(Book book);

	public List<Book> getAllBooks();

	public Book getBookById(Long id);
	
	public Boolean deleteBookById(Long id);
	
	public Book updateBook(Book book);

}
