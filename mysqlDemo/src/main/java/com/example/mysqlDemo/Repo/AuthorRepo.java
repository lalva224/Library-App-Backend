package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Integer> {

}
