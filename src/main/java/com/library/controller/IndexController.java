package com.library.controller;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

    private AuthorService authorService;

    @Autowired
    public IndexController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "index";
    }

    @RequestMapping("/page")
    public String page() {
        return "page";
    }

    @GetMapping("/test")
    public String testMapping(){
        return "redirect:/";
    }

    @PostMapping("/testForm")
    public String testPost(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("testParam") String [] bookArray){
//        System.out.println(firstName);
//        System.out.println(lastName);
//        for(int i = 0; i < bookArray.length; i++){
//            System.out.println(bookArray[i]);
//        }

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
