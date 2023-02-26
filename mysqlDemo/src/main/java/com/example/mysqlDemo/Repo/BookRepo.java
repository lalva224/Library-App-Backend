package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<Book,Integer> {
}
