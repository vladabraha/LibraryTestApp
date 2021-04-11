package cz.braha.applicanttest.services;

import cz.braha.applicanttest.exceptions.DoesNotExist;
import cz.braha.applicanttest.model.Book;
import cz.braha.applicanttest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void createBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Book findByID(int id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		return bookOptional.orElse(null);
	}

	@Override
	public Book findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public List<Book> findByAuthor(int authorID) {
		return bookRepository.findByAuthorId(authorID);
	}

	@Override
	public void updateBook(Book book) {
		Optional<Book> bookFromRepository = bookRepository.findById(book.id);
		if (!bookFromRepository.isPresent()) {
			return;
		}
		bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteBook(int id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if (!bookOptional.isPresent()) {
			throw new DoesNotExist("Book with provided id: " + id +" does not exist");
		}
		bookRepository.delete(bookOptional.get());
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
