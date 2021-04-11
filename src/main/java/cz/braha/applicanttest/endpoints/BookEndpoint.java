package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.dtos.AuthorDTO;
import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface BookEndpoint {
	ResponseEntity getAllBooks();
	ResponseEntity findByID(Long id);
	ResponseEntity findByISBN(String isbn);
	ResponseEntity findByAuthor(Long authorID);

	ResponseEntity<Author> createBook(Book book);
	ResponseEntity deleteBook(Long id);
	ResponseEntity updateBook(AuthorDTO author);
}
