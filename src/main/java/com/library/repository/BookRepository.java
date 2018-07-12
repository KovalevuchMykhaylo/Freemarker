package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select d from Author p join p.books d where p.id = ?1")
    List<Book> findAllByAuthorId(Long patientId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete FROM library.author_book where book_id=?1")
    void deleteBookRelation(Long id);

    @Transactional
    @Modifying
    void deleteBookById(Long id);
}
