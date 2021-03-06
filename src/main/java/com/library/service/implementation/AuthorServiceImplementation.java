package com.library.service.implementation;

import com.library.entity.Author;
import com.library.repository.AuthorRepository;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author saveAndFlush(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(Long delete) {
        authorRepository.deleteAuthorRelation(delete);
        authorRepository.deleteAuthorById(delete);
    }
}
