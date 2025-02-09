package com.ggplay149.book_search_service.repo.book;

import com.ggplay149.book_search_service.domain.Book;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {

    List<Book> getAllBookList();

    Book getBookById(String bookId);

    List<Book> getBookListByCategory(String category);

    List<Book> getBookListByPublisher(String category);

    Set<Book> getBookListByFilter(Map<String,List<String>> filter);

}
