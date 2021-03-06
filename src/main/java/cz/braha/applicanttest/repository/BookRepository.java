package cz.braha.applicanttest.repository;

import cz.braha.applicanttest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findAll();

    Book findByIsbn(String isbn);
    List<Book> findByAuthorId(int author);

    void deleteById(int id);

}
