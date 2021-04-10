package cz.braha.applicanttest.dtos;

import cz.braha.applicanttest.objects.BookGenre;

import java.util.Set;

public class BookDTO {

	private String isbn;
	private String name;

	private Set<Integer> genres;
}
