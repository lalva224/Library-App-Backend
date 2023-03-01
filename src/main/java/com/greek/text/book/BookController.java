package com.greek.text.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;
    @GetMapping("/get-all-books")
    public ResponseEntity<BookResponse> getAllBooks()
    {
        return  ResponseEntity.ok(BookResponse.builder().allBooks(this.bookService.books()).build());
    }

    @PostMapping("/book")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<SaveBookResponse> SaveBook(@RequestBody BookEntity bookEntity)
    {
        return ResponseEntity.ok(SaveBookResponse.builder().isBookSave(this.bookService.saveBook(bookEntity)).build());
    }

    @GetMapping("/book-by-isbn/{isbn}")
    public ResponseEntity<FetchResponseByIsbn> fetchByIsbn(@PathVariable String isbn)
    {
        return ResponseEntity.ok(FetchResponseByIsbn.builder().isbn(this.bookService.getByIsbn(Integer.parseInt(isbn))).build());
    }
    @GetMapping("/list-by-author/{id}")
    public ResponseEntity<BookResponse> fetchListByAuthorId(@PathVariable String id)
    {
        return ResponseEntity.ok(BookResponse.builder().allBooks(this.bookService.listByAuthorId(Integer.parseInt(id))).build());
    }



}
