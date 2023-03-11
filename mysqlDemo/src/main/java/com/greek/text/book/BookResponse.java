package com.greek.text.book;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    public List<BookEntity> allBooks;
}
