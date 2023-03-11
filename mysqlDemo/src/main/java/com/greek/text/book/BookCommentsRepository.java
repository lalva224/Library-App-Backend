package com.greek.text.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCommentsRepository extends JpaRepository<BooksComments,Integer>
{

}
