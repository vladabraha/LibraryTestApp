package cz.braha.applicanttest.endpoints;


import cz.braha.applicanttest.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorEndpoint {
    List<Author> getAllAuthors(); //todo zde byl set - ma to nejaky duvod?
	ResponseEntity<Author> findByID(int id);
	ResponseEntity<Author> createAuthor(Author author);
    ResponseEntity<Author> deleteAuthor(int id);
	ResponseEntity<Author> updateAuthor(Author author);
}
