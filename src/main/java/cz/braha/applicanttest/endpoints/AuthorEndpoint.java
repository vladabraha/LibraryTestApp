package cz.braha.applicanttest.endpoints;


import cz.braha.applicanttest.model.Author;
import org.springframework.http.ResponseEntity;

public interface AuthorEndpoint {
    ResponseEntity<?> getAllAuthors();
	ResponseEntity<?> findByID(int id);
	ResponseEntity<?> createAuthor(Author author);
    ResponseEntity<?> deleteAuthor(int id);
	ResponseEntity<?> updateAuthor(Author author);
}
