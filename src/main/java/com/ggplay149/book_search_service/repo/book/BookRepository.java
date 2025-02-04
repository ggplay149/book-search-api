package com.ggplay149.book_search_service.repo.book;

import com.ggplay149.book_search_service.domain.Book;
import java.util.List;

public interface BookRepository {

    List<Book> getAllBookList();

}
