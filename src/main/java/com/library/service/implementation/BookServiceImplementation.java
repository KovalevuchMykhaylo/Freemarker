package com.library.service.implementation;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findByAuthorId(Long id) {
        return bookRepository.findAllByAuthorId(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBookRelation(id);
        bookRepository.deleteBookById(id);
    }
}
