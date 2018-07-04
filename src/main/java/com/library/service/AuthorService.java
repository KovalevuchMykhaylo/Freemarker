package com.library.service;

import com.library.entity.Author;

public interface AuthorService {

    void save(Author author);

    Author saveAndFlush(Author author);

    Author findByName(String name);
}
