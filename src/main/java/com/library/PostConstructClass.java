package com.library;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostConstructClass {

    private AuthorService authorService;

    @Autowired
    public PostConstructClass(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostConstruct
    public void createBooks() {

        List<Book> books = new ArrayList<>();
        books.add(new Book("First"));
        books.add(new Book("Second"));
        books.add(new Book("Third"));

        if (authorService.findByName("First") == null) {
            Author author1 = new Author("First", "First");
            author1.setBooks(books);
            authorService.save(author1);

        }
    }
}
