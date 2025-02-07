package com.ggplay149.book_search_service.ui.controller;

import com.ggplay149.book_search_service.application.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public String requestBookList(Model model) {
        model.addAttribute("bookList", bookService.getAllBookList());
        return "books";
    }

    @GetMapping("/all")
    public ModelAndView requestAllBookList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookList", bookService.getAllBookList());
        modelAndView.setViewName("books");
        return modelAndView;
    }

}
