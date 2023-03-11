package com.greek.text.user.auther;

import com.greek.text.user.Authors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AutherRepository autherRepository;

    public List<Authors> getAllAuthors() {
        return this.autherRepository.findAll();
    }

    public Authors saveAuthor(Authors authors) {
        return this.autherRepository.save(authors);
    }


}
