package com.library.repository;

import com.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete FROM library.author_book where author_id=?1")
    void deleteAuthorRelation(Long id);

    @Transactional
    @Modifying
    void deleteAuthorById(Long id);
}
