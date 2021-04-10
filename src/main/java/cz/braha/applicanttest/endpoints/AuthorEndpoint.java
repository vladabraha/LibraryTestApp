package cz.braha.applicanttest.endpoints;


import cz.braha.applicanttest.dtos.AuthorDTO;
import cz.braha.applicanttest.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface AuthorEndpoint {
    Set<AuthorDTO> getAllAuthors();
    AuthorDTO findByID(Long id);
	ResponseEntity<Author> createAuthor(Author author);
    void deleteAuthor(Long id);
    void updateAuthor(AuthorDTO author);
}
