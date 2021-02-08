package blog.service.impl;

import blog.model.Author;
import blog.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class InitDataService {
    private final AuthorService authorService;
    @PostConstruct
    private void init(){
        if(authorService.getAll().size()==0){
            log.info("Initialize database");
            final Author author = new Author();
            author.setLastName("Родин");
            author.setName("Андрей");
            author.setBirthDay(new Date());
            authorService.createAuthor(author);
        }
    }
}
