package com.greek.text.auther;

import com.greek.text.user.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AutherRepository extends JpaRepository<Authors,Integer> {

    @Override
    List<Authors> findAll();
}
