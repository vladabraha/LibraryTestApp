package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.dtos.AuthorDTO;
import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.repository.AuthorRepository;
import cz.braha.applicanttest.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController implements AuthorEndpoint{

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

//    /**
//     * Get all rules from database
//     * @return all rulesets
//     */
//    @GetMapping(value = "rules")
//    public ResponseEntity<List<Ruleset>> getAllRules() {
//        List<Ruleset> rulesets = rulesetService.findAllRulesets();
//        return new ResponseEntity<>(rulesets, HttpStatus.OK);
//    }
//
    /**
     * Create new author
     * @param author - author to create
     * @return HttpStatus.CREATED
     */
	@Override
    @PostMapping(path = "author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author authorResponse = authorService.saveAuthor(author);
        return new ResponseEntity<>(authorResponse, HttpStatus.CREATED);
    }

	@Override
	public Set<AuthorDTO> getAllAuthors() {
		return null;
	}

	@Override
	public AuthorDTO findByID(Long id) {
		return null;
	}

	@Override
	public void deleteAuthor(Long id) {

	}

	@Override
	public void updateAuthor(AuthorDTO author) {

	}
//
//    /**
//     * Remove rule
//     * @param ids - id of rule to remove
//     */
//    @PostMapping(path = "rules/remove")
//    public ResponseEntity<Void> removeRule(@RequestBody List<Integer> ids) {
//        rulesetService.deleteByIdIn(ids);
//        TransactionCategorizer transactionCategorizer = new TransactionCategorizer();
//        transactionCategorizer.categorizeTransactions();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    /**
//     * Update rule
//     * @param rule - rule to update
//     * @return ok
//     */
//    @PutMapping(path = "rules")
//    public ResponseEntity<Ruleset> updateRule(@RequestBody Ruleset rule) {
//        Ruleset ruleset = rulesetService.saveRuleset(rule);
//        return new ResponseEntity<>(ruleset, HttpStatus.OK);
//    }

}
