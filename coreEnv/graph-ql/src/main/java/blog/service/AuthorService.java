package blog.service;

import blog.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author createAuthor(Author author);
    Author getById(Long id);
}
