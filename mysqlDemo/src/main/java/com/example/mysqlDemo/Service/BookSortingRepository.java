package com.example.mysqlDemo.Service;

import org.springframework.data.repository.CrudRepository;

import com.example.mysqlDemo.Modals.Book;

public interface BookSortingRepository extends CrudRepository<Book, Integer> {

}
