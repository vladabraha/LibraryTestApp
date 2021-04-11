package cz.braha.applicanttest.dtos;

import cz.braha.applicanttest.model.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDtoIn {

	private String name;

	public AuthorDtoIn(Author author) {
		name = author.getName();
	}
}
