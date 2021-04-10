package cz.braha.applicanttest.services;

import cz.braha.applicanttest.model.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
	// Saves given Ruleset to the DB
	Author saveAuthor(Author author);
}
