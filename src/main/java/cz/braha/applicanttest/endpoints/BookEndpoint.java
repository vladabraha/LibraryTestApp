package cz.braha.applicanttest.endpoints;

import cz.braha.applicanttest.dtos.AuthorDTO;

import java.util.Set;

public interface BookEndpoint {
    Set<AuthorDTO> getAllBooks();
    AuthorDTO findByID(Long id);
    AuthorDTO findByISBN(String isbn);
    AuthorDTO findByAuthor(Long authorID);

    void createBook(AuthorDTO author);
    void deleteBook(Long id);
    void updateBook(AuthorDTO author);
}
