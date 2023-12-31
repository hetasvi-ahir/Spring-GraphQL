package com.query.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.entity.Book;
import com.query.repository.BookRepository;
import com.query.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		Book saveBook = bookRepository.save(book);
		return saveBook;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = bookRepository.findAll();

		return list;
	}

	@Override
	public Book getBookById(Long id) {

		Optional<Book> findById = bookRepository.findById(id);
		Book book = findById.get();
		return book;
	}

	@Override
	public Boolean deleteBookById(Long id) {
		try {
			bookRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Book updateBook(Book book) 
	{
		Book book2 = new Book();
		Optional<Book> findById = bookRepository.findById(book.getId());
		if (findById.isPresent()) {
			book2 = findById.get();
		}

		book2.setId(book.getId());
		book2.setTitle(book.getTitle());
		book2.setPages(book.getPages());
		book2.setPrice(book.getPrice());

		Book result = bookRepository.save(book2);

		return result;
	}

}
