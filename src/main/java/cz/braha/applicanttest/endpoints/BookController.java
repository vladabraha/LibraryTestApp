package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.dtos.AuthorDTO;
import cz.braha.applicanttest.exceptions.DoesNotExist;
import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.model.Book;
import cz.braha.applicanttest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController implements BookEndpoint {

	public static final String NOT_EXISTING_AUTHOR = "Author with this id has not been found";
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}


	@Override
	public ResponseEntity getAllBooks() {
		return null;
	}

	@Override
	public ResponseEntity findByID(Long id) {
		return null;
	}

	@Override
	public ResponseEntity findByISBN(String isbn) {
		return null;
	}

	@Override
	public ResponseEntity findByAuthor(Long authorID) {
		return null;
	}

	//    todo java doc
	@Override
	@PostMapping(path = "book")
	public ResponseEntity<Author> createBook(@RequestBody @Valid Book book) {
		bookService.createBook(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity deleteBook(Long id) {
		return null;
	}

	@Override
	public ResponseEntity updateBook(AuthorDTO author) {
		return null;
	}


//	todo
//	@Override
//	@GetMapping(path = "author")
//	public ResponseEntity findByID(@RequestBody int id) throws DoesNotExist {
//		Author author = bookService.getAuthorById(id);
//		if (author == null) {
//			return new ResponseEntity<>(NOT_EXISTING_AUTHOR, HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(author, HttpStatus.FOUND);
//	}
//
//	@Override
//	@GetMapping(path = "allAuthors")
//	public List<Author> getAllAuthors() {
//		return bookService.getAllAuthors();
//	}
//
//
//	@Override
//	@DeleteMapping(path = "deleteAuthor")
//	public ResponseEntity deleteAuthor(@RequestBody int id) {
//		try {
//			bookService.deleteAuthor(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@Override
//	@PutMapping(path = "updateAuthor")
//	public ResponseEntity updateAuthor(@RequestBody @Valid Author author) {
//		Author responseAuthor = bookService.updateAuthor(author);
//		if (responseAuthor == null) {
//			return new ResponseEntity<>(NOT_EXISTING_AUTHOR, HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(responseAuthor, HttpStatus.OK);
//
//	}


}
