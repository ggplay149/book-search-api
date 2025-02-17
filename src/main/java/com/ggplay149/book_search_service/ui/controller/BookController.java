package com.ggplay149.book_search_service.ui.controller;

import com.ggplay149.book_search_service.application.book.BookService;
import com.ggplay149.book_search_service.domain.Book;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Value("${file.uploadDir}")
    String fileDir;

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

    @GetMapping("/add")
    public String requestAddBookForm() {
        return "addBook";
    }

    @PostMapping("/add")
    public String submitAddNewBook(@ModelAttribute Book book) {

        MultipartFile bookImage = book.getBookImage();
        String saveName = bookImage.getOriginalFilename();
        File saveFile = new File(fileDir,saveName);
        if(bookImage != null && !bookImage.isEmpty()){
            try{
                bookImage.transferTo(saveFile);
            }catch (Exception e){
                throw new RuntimeException("도서 이미지 업로드가 실패했습니다.",e);
            }
        }
        book.setFileName(saveName);
        bookService.setNewBook(book);
        return "redirect:/books";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("addTitle","신규 도서 등록");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description",
                "publisher", "category", "unitsInStock", "totalPages"
            , "releaseDate", "condition","bookImage");
    }

}
