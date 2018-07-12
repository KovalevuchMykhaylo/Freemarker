package com.library.controller;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.service.AuthorService;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private AuthorService authorService;

    private BookService bookService;

    @Autowired
    public IndexController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("authorBooks", null);
        return "index";
    }

    @RequestMapping("/page")
    public String page() {
        return "page";
    }

    @GetMapping("/books/{authorId}")
    public String showAllAuthorBooks(@PathVariable("authorId") Long id, Model model){
        model.addAttribute("authors", authorService.findAll());
        StringBuilder content = new StringBuilder();
        List<Book> books = bookService.findByAuthorId(id);
        if (books != null) {
            for (Book b : books) {
                content.append("<p class=\"listOfBooks\">");
                content.append("<a href=\"/books/")
                        .append(id)
                        .append("/")
                        .append(b.getId())
                        .append("\">")
                        .append(b.getName())
                        .append("</a>");
                content.append("</p>");
            }
            model.addAttribute("authorBooks", content.toString());
        }
        return "index";
    }

    @RequestMapping("/books/{authorId}/{bookId}")
    public String deleteBook(@PathVariable("bookId")Long bookId, @PathVariable("authorId")Long authorId, Model model){
        bookService.deleteBook(bookId);
//        return showAllAuthorBooks(authorId, model);
        return "redirect:/";
    }

    @PostMapping("/testForm")
    public String testPost(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("testParam") String [] bookArray){
        Author author = new Author(firstName, lastName);
        if(bookArray != null) {
            List<Book> books = new ArrayList<>();
            for (String aBookArray : bookArray) {
                books.add(new Book(aBookArray));
            }
            author.setBooks(books);
        }
        authorService.save(author);

        return "redirect:/";
    }
}
