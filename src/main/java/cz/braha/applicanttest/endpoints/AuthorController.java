package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.exceptions.DoesNotExist;
import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController implements AuthorEndpoint {

	public static final String NOT_EXISTING_AUTHOR = "Author with this id has not been found";
	public static final String UNKNOWN_ERROR = "Unknown error";
	public static final String AUTHOR_WITH_THIS_ID_HAS_NOT_BEEN_FOUND = "Author with this id has not been found";
	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	//Try catche jsou zde umisteny z duvodu vrácení uživatelsky přívětivějších případných chyb a nezobrazování celého stacktrace v response
	@Override
	@PostMapping(path = "author")
	public ResponseEntity<?> createAuthor(@RequestBody @Valid Author author) {
		try {
			authorService.saveAuthor(author);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(UNKNOWN_ERROR, HttpStatus.NOT_ACCEPTABLE);
		}
	}


	@Override
	@GetMapping(path = "author")
	public ResponseEntity<?> findByID(@RequestBody int id) {
		try {
			Author author = authorService.getAuthorById(id);
			if (author == null) {
				return new ResponseEntity<>(NOT_EXISTING_AUTHOR, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(author, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(UNKNOWN_ERROR, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	@GetMapping(path = "allAuthors")
	public ResponseEntity<?> getAllAuthors() {
		try {
			return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(UNKNOWN_ERROR, HttpStatus.NOT_ACCEPTABLE);
		}
	}


	@Override
	@DeleteMapping(path = "deleteAuthor")
	public ResponseEntity<?> deleteAuthor(@RequestBody int id) {
		try {
			authorService.deleteAuthor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(AUTHOR_WITH_THIS_ID_HAS_NOT_BEEN_FOUND,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@PutMapping(path = "updateAuthor")
	public ResponseEntity<?> updateAuthor(@RequestBody @Valid Author author) {
		try {
			Author responseAuthor = authorService.updateAuthor(author);
			if (responseAuthor == null) {
				return new ResponseEntity<>(NOT_EXISTING_AUTHOR, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(responseAuthor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(UNKNOWN_ERROR, HttpStatus.NOT_ACCEPTABLE);
		}

	}


}
