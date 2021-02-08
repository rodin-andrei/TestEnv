package blog.service.impl;

import blog.model.Author;
import blog.repository.AuthorRepository;
import blog.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getOne(id);
    }
}
