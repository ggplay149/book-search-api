package com.ggplay149.book_search_service.application.book;

import com.ggplay149.book_search_service.domain.Book;
import com.ggplay149.book_search_service.repo.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    @Override
    public Book getBookById(String bookId) { return bookRepository.getBookById(bookId); }

    @Override
    public List<Book> getBookListByCategory(String category) { return bookRepository.getBookListByCategory(category);}

}
