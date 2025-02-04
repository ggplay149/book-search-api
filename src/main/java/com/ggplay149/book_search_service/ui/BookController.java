package com.ggplay149.book_search_service.ui;

import com.ggplay149.book_search_service.application.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public String requestBookList(Model model){
        model.addAttribute("bookList",bookService.getAllBookList());
        return "books";
    }

}
