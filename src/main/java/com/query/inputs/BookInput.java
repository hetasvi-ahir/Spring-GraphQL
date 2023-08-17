package com.query.inputs;

import com.query.entity.Author;

import lombok.Data;

@Data
public class BookInput {
	private String title;
	private String description;
	private String author;
	//private Author author;
	private Long pages;
	private Long price;

}
