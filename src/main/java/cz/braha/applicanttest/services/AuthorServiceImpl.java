package cz.braha.applicanttest.services;

import cz.braha.applicanttest.model.Author;
import cz.braha.applicanttest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository AuthorRepository;

	@Override
	public Author saveAuthor(Author author) {
		return AuthorRepository.save(author);
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
