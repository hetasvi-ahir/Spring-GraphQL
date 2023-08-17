package com.query.inputs;

import lombok.Data;

@Data
public class UpdateInput 
{
	private Long id;
	private String title;
	private Long pages;
	private Long price;

}
