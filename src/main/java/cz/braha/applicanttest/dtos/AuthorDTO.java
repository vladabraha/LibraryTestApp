package cz.braha.applicanttest.dtos;

import cz.braha.applicanttest.model.Author;

public class AuthorDTO {

	private String name;

	public AuthorDTO(Author author) {
		name = author.getName();
	}
}
