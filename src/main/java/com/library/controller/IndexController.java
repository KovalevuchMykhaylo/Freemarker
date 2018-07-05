package com.library.controller;

import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class IndexController {

    private AuthorService authors;

    @Autowired
    public IndexController(AuthorService authors) {
        this.authors = authors;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("authors", authors.findAll());
        return "index";
    }

    @GetMapping("/test")
    public String testMapping(){
        return "redirect:/";
    }

    @PostMapping("/testForm")
    public String testPost(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("testParam") String [] bookArray){
        System.out.println(firstName);
        System.out.println(lastName);
        for(int i = 0; i < bookArray.length; i++){
            System.out.println(bookArray[i]);
        }
        return "redirect:/";
    }
}
