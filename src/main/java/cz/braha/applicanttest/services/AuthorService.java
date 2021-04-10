package cz.braha.applicanttest.services;

import cz.braha.applicanttest.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

	Author saveAuthor(Author author);
	Author getAuthorById(int id);
	Author updateAuthor(Author author);
	List<Author> getAllAuthors();
	void deleteAuthor(int id);
}
