package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.Future;

@Repository
public interface BookRepo extends CrudRepository<Book,Integer> {

    @Query(value = "SELECT * FROM book WHERE author_id = :authorId",nativeQuery = true)
    Future<List<Book>> getBooksByAuthor(@Param ("authorId") int id);


}
