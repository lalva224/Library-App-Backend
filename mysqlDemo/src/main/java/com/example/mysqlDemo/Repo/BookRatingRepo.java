package com.example.mysqlDemo.Repo;

import com.example.mysqlDemo.Model.BookRating;
import com.example.mysqlDemo.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRatingRepo extends CrudRepository<BookRating, User>
{
}
