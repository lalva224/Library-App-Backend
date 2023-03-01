package com.greek.text.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    List<BookEntity> books() {
        return this.bookRepository.findAll();
    }
    List<BookEntity> listByAuthorId(Integer id) {
        return this.bookRepository.findByAuthor(id);
    }

    BookEntity saveBook(BookEntity bookEntity) {
        return this.bookRepository.save(bookEntity);
    }
    BookEntity getByIsbn(Integer isbn)
    {
        return this.bookRepository.findByIsbn(isbn);
    }

}
