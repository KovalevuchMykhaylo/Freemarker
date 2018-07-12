package com.library.service;

import com.library.entity.Author;

import java.util.List;

public interface AuthorService {

    void save(Author author);

    Author saveAndFlush(Author author);

    Author findByName(String name);

    List<Author> findAll();

    void deleteAuthor(Long delete);
}
