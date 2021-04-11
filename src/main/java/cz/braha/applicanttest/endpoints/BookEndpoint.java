package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookEndpoint {
	ResponseEntity<?> getAllBooks();
	ResponseEntity<?> findByID(int id);
	ResponseEntity<?> findByISBN(String isbn);
	ResponseEntity<?> findByAuthor(int authorID);

	ResponseEntity<?> createBook(Book book);
	ResponseEntity<?> deleteBook(int id);
	ResponseEntity<?> updateBook(Book author);
}
