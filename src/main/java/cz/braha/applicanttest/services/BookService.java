package cz.braha.applicanttest.services;

import cz.braha.applicanttest.model.Book;

import java.util.List;

public interface BookService {

	List<Book> getAllBooks();
	Book findByID(int id);
	Book findByIsbn(String isbn);
	List<Book> findByAuthor(int authorID);

	void createBook(Book book);
	void deleteBook(int id);
	void updateBook(Book book);
}
