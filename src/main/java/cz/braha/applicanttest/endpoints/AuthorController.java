package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.exceptions.DoesNotExist;
import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController implements AuthorEndpoint {

	public static final String NOT_EXISTING_AUTHOR = "Author with this id has not been found";
	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}


	//    todo java doc
	@Override
	@PostMapping(path = "author")
	public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author) {
		Author authorResponse = authorService.saveAuthor(author);
		return new ResponseEntity<>(authorResponse, HttpStatus.CREATED);
	}


	@Override
	@GetMapping(path = "author")
	public ResponseEntity findByID(@RequestBody int id) throws DoesNotExist {
		Author author = authorService.getAuthorById(id);
		if (author == null) {
			return new ResponseEntity<>(NOT_EXISTING_AUTHOR, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(author, HttpStatus.FOUND);
	}

	@Override
	@GetMapping(path = "allAuthors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}


	@Override
	@DeleteMapping(path = "deleteAuthor")
	public ResponseEntity deleteAuthor(@RequestBody int id) {
		try {
			authorService.deleteAuthor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@PutMapping(path = "updateAuthor")
	public ResponseEntity updateAuthor(@RequestBody @Valid Author author) {
		Author responseAuthor = authorService.updateAuthor(author);
		if (responseAuthor == null) {
			return new ResponseEntity<>(NOT_EXISTING_AUTHOR, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(responseAuthor, HttpStatus.OK);

	}


}
