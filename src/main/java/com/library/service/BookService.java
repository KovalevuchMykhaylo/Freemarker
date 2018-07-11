package com.library.service;

import com.library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void save (Book book);

    List<Book> findByAuthorId(Long id);
}
