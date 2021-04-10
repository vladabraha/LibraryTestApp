package cz.braha.applicanttest.services;

import cz.braha.applicanttest.exceptions.DoesNotExist;
import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository AuthorRepository;

	@Override
	public Author saveAuthor(Author author) {
		return AuthorRepository.save(author);
	}

	@Override
	public Author getAuthorById(int id) {
		Optional<Author> authorOptional = AuthorRepository.findById(id);
		return authorOptional.orElse(null);
	}

	@Override
	public Author updateAuthor(Author author) {
		Optional<Author> authorOptional = AuthorRepository.findById(author.id);
		if (!authorOptional.isPresent()){
			return null;
		}
		return AuthorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return AuthorRepository.findAll();
	}

	@Override
	public void deleteAuthor(int id) {
		Optional<Author> authorOptional = AuthorRepository.findById(id);
		if (!authorOptional.isPresent()){
			throw new DoesNotExist("Author with provided id does not exist");
		}
		AuthorRepository.delete(authorOptional.get());
	}


//    // Returns Ruleset by given ID
//    @Override
//    public Ruleset findRulesetById(int id) {
//        return rulesetRepository.findById(id);
//    }
//
//    // Returns list of all Rulesets
//    @Override
//    public List<Ruleset> findAllRulesets() {
//        return rulesetRepository.findAll();
//    }

    // Saves given Ruleset to the DB

//    // Deletes Ruleset with given ID
//    @Override
//    public void deleteById(int id) {
//        rulesetRepository.deleteById(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteByIdIn(List<Integer> ids) {
//        rulesetRepository.deleteByIdIn(ids);
//    }
}
