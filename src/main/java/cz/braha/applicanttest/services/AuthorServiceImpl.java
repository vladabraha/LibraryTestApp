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

	public static final String AUTHOR_WITH_PROVIDED_ID_DOES_NOT_EXIST = "Author with provided id does not exist";

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(int id) {
		Optional<Author> authorOptional = authorRepository.findById(id);
		return authorOptional.orElse(null);
	}

	@Override
	public Author updateAuthor(Author author) {
		Optional<Author> authorOptional = authorRepository.findById(author.id);
		if (!authorOptional.isPresent()) {
			return null;
		}
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public void deleteAuthor(int id) {
		Optional<Author> authorOptional = authorRepository.findById(id);
		if (!authorOptional.isPresent()) {
			throw new DoesNotExist(AUTHOR_WITH_PROVIDED_ID_DOES_NOT_EXIST);
		}
		authorRepository.delete(authorOptional.get());
	}
}
