package com.greek.text.user.auther;

import com.greek.text.user.Authors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/get-all-authors")
    public ResponseEntity<AuthorResponse> getAllAuthors() {
        return ResponseEntity.ok().body(AuthorResponse.builder().allAuthors(this.authorService.getAllAuthors()).build());
    }

    @PostMapping("/author")
    public ResponseEntity<SaveResponseForAuthor> saveAuthor(@RequestBody Authors authors) {
        return ResponseEntity.ok().body(SaveResponseForAuthor.builder().isSavedAuthors(this.authorService.saveAuthor(authors)).build());
    }
}
