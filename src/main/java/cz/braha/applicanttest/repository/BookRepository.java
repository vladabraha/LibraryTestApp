package cz.braha.applicanttest.repository;

import cz.braha.applicanttest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findById(int id);

    List<Book> findAll();

    void deleteById(int id);

    void deleteByIdIn(List<Integer> ids);
}
