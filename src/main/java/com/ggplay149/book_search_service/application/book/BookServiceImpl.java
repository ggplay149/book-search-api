package com.ggplay149.book_search_service.application.book;

import com.ggplay149.book_search_service.domain.Book;
import com.ggplay149.book_search_service.repo.book.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }
}
