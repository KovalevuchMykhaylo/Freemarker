package com.library.controller;

import com.library.entity.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private static List<Author> authors = new ArrayList<>();

    static {
        authors.add(new Author("test", "test"));
        authors.add(new Author("test 1", "test 1"));
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("test", "test");
        model.addAttribute("authors", authors);
        return "index";
    }
}
