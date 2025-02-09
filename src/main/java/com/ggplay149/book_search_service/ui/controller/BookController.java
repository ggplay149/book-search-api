package com.ggplay149.book_search_service.ui.controller;

import com.ggplay149.book_search_service.application.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String requestAllBookList(Model model) {
        model.addAttribute("bookList", bookService.getAllBookList());
        return "books";
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
        model.addAttribute("bookList", bookService.getBookListByCategory(bookCategory));
        return "books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookfilter,
                                       Model model) {
        model.addAttribute("bookList", bookService.getBookListByFilter(bookfilter));
        return "books";
    }

}
