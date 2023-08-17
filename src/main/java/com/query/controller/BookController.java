package com.query.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.query.entity.Book;
import com.query.inputs.BookInput;
import com.query.inputs.UpdateInput;
import com.query.service.BookService;

import graphql.GraphQLContext;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import jakarta.servlet.http.HttpServletRequest;

/*@RestController
@RequestMapping("/books")*/
@Controller
public class BookController {

	@Autowired
	public BookService bookService;

	/* @PostMapping("/save") */
	@MutationMapping("createBook")
	// public Book saveBook(@RequestBody Book book) {
	public Book saveBook(@Argument BookInput book) {
		Book b = new Book();
		b.setTitle(book.getTitle());
		b.setDescription(book.getDescription());
		b.setAuthor(book.getAuthor());
		// b.setAuthor(book.getAuthor());
		b.setPages(book.getPages());
		b.setPrice(book.getPrice());
		Book createBook = bookService.createBook(b);
		return createBook;
	}

	/* @GetMapping("/getAll") */

	// @SchemaMapping
	/*
	 * @QueryMapping("allBooks") public List<Book> getBooks() { List<Book> allBooks
	 * = bookService.getAllBooks(); return allBooks; }
	 */

	/* @GetMapping("/getById") */
	@QueryMapping("getBook")
	// public Book getBooks(@RequestParam("id") Long id) {
	public Book getBooks(@Argument Long bookId) {
		Book allBooks = bookService.getBookById(bookId);
		return allBooks;
	}

	@MutationMapping("updateBook")
	public Book updateBook(@Argument UpdateInput input) {
		Book book = new Book();
		book.setId(input.getId());
		book.setTitle(input.getTitle());
		book.setPages(input.getPages());
		book.setPrice(input.getPrice());
		Book updateBook = bookService.updateBook(book);
		return updateBook;
	}

	@MutationMapping("deleteBook")
	public Boolean deleteBook(@Argument Long bookId) {

		Boolean deleteBookById = bookService.deleteBookById(bookId);
		return deleteBookById;
	}

	@QueryMapping("allBooks")
	public List<Book> get(@RequestHeader HttpHeaders headers
			//DataFetchingEnvironment environment, GraphQLContext context)
){
		/*
		 * System.out.println("CONTEXT::::" + context); String authorization =
		 * context.getOrDefault("Authorization", context.get(HttpServletRequest.class));
		 * System.out.println("Hello, " + authorization); HttpServletRequest req =
		 * context.get(HttpServletRequest.class); System.out.println(req);
		 * 
		 * HttpServletRequest httpServletRequest =
		 * environment.getGraphQlContext().get(HttpServletRequest.class); String header
		 * = httpServletRequest.getHeader("Authorization");
		 * System.out.println("Header :::: " + header);
		 */
		

		
		
		List<Book> allBooks = bookService.getAllBooks();
		return allBooks;
	}

}
