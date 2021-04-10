package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.dtos.AuthorDTO;
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
public class AuthorController implements AuthorEndpoint{

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
	public ResponseEntity<Author> findByID(@RequestBody int id) {
		Author author = authorService.getAuthorById(id);
		if (author != null) {
			return new ResponseEntity<>(author, HttpStatus.FOUND);
		}else{
//		todo zjisti jak pridat zpravu, ze author s danym id neexistuje
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	@Override
	@GetMapping(path = "allAuthors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}


	@Override
	public ResponseEntity deleteAuthor(int id) {
		try {
			authorService.deleteAuthor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Author> updateAuthor(@Valid Author author) {
		try {
			Author responseAuthor = authorService.updateAuthor(author);
			return new ResponseEntity<>(responseAuthor, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
