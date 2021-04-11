package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.model.Book;
import cz.braha.applicanttest.services.AuthorService;
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
	public static final String BOOK_WITH_THIS_ID_DOESNT_EXIST = "Book with provided id doesn't exist";
	public static final String BOOK_WITH_THIS_AUTHOR_ID_DOESNT_EXIST = "Book with provided authorId doesn't exist";
	public static final String BOOK_WITH_THIS_ISBN_DOESNT_EXIST = "Book with provided isbn doesn't exist";
	public static final String THIS_AUTHOR_DOES_NOT_EXIST_IN_THE_SYSTEM = "This author does not exist in the system";
	public static final String THIS_ISBN_ALREADY_EXIST_IN_THE_SYSTEM = "This isbn already exist in the system";
	private final BookService bookService;
	private final AuthorService authorService;

	@Autowired
	public BookController(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}


	@Override
	@GetMapping(path = "getAllBooks")
	public ResponseEntity getAllBooks() {
		List<Book> allBooks = bookService.getAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.FOUND);
	}

	@Override
	@GetMapping(path = "findByID")
	public ResponseEntity findByID(@RequestBody int id) {
		Book book;
		try {
			book = bookService.findByID(id);
		} catch (Exception e) {
			return new ResponseEntity<>(BOOK_WITH_THIS_ID_DOESNT_EXIST, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book, HttpStatus.FOUND);
	}

	@Override
	@GetMapping(path = "findByISBN")
	public ResponseEntity findByISBN(@RequestBody String isbn) {
		Book book = bookService.findByIsbn(isbn);
		if (book == null) {
			return new ResponseEntity<>(BOOK_WITH_THIS_ISBN_DOESNT_EXIST, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(book, HttpStatus.FOUND);
		}
	}

	@Override
	@GetMapping(path = "findByAuthor")
	public ResponseEntity findByAuthor(@RequestBody int authorID) {
		Author authorById = authorService.getAuthorById(authorID);
		if (authorById == null){
			return new ResponseEntity<>(BOOK_WITH_THIS_AUTHOR_ID_DOESNT_EXIST, HttpStatus.NOT_FOUND);
		}
		List<Book> books;
		try {
			books = bookService.findByAuthor(authorID);
		} catch (Exception e) {
			return new ResponseEntity<>(BOOK_WITH_THIS_AUTHOR_ID_DOESNT_EXIST, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(books, HttpStatus.FOUND);
	}


	@Override
	@PostMapping(path = "createBook")
	public ResponseEntity createBook(@RequestBody @Valid Book book) {
		//validate incoming book
		if (bookService.findByIsbn(book.getIsbn()) != null ){
			return new ResponseEntity<>(THIS_ISBN_ALREADY_EXIST_IN_THE_SYSTEM, HttpStatus.NOT_FOUND);
		}
		if (authorService.getAuthorById(book.getAuthorId()) == null){
			return new ResponseEntity<>(THIS_AUTHOR_DOES_NOT_EXIST_IN_THE_SYSTEM, HttpStatus.NOT_FOUND);
		}

		bookService.createBook(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	@DeleteMapping(path = "deleteBook")
	public ResponseEntity deleteBook(@RequestBody int id) {
		try {
			bookService.deleteBook(id);
		} catch (Exception e) {
			return new ResponseEntity<>(BOOK_WITH_THIS_ID_DOESNT_EXIST, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	@PutMapping(path = "updateBook")
	public ResponseEntity updateBook(@RequestBody @Valid Book book) {
		try {
			bookService.updateBook(book);
		} catch (Exception e) {
			return new ResponseEntity<>(BOOK_WITH_THIS_ID_DOESNT_EXIST, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
