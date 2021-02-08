package blog.controller;

import blog.model.Author;
import blog.repository.AuthorRepository;
import blog.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(path = "all")
    public List<Author> all() {
        return authorService.getAll();
    }
    @GetMapping(path = "{id}")
    public Author author(Long id) {
        return authorService.getById(id);
    }
}
