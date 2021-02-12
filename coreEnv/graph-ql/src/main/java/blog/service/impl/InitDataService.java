package blog.service.impl;

import blog.model.Author;
import blog.model.Post;
import blog.repository.AuthorRepository;
import blog.repository.PostRepository;
import blog.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;

@Service
@Slf4j
@RequiredArgsConstructor
public class InitDataService {
    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;
    @PostConstruct
    private void init(){
        if(authorRepository.findAll().size()==0){
            log.info("Initialize database");

            final Author author = new Author();
            author.setLastName("Родин");
            author.setName("Андрей");
            author.setBirthDay(new Date());


            final Post post = new Post();
            post.setAuthor(author);
            post.setTitle("Пост1 Андрея");
            post.setText("Первый пост андрея");

            final Post post2 = new Post();
            post2.setAuthor(author);
            post2.setTitle("Пост2 Андрея");
            post2.setText("Второй пост андрея");

            HashSet<Post> posts = new HashSet<>();
            posts.add(post);
            posts.add(post2);

            author.setPosts(posts);


           authorRepository.save(author);
           postRepository.saveAll(posts);


            final Author author2 = new Author();
            author2.setLastName("Шолопа");
            author2.setName("Александр");
            author2.setBirthDay(new Date());


            final Post post3 = new Post();
            post3.setAuthor(author2);
            post3.setTitle("Пост1 Шолопы");
            post3.setText("Первый пост Шолопы");

            final Post post4 = new Post();
            post4.setAuthor(author2);
            post4.setTitle("Пост2 Шолопы");
            post4.setText("Второй пост Шолопы");

            HashSet<Post> posts2 = new HashSet<>();
            posts2.add(post3);
            posts2.add(post4);

            author2.setPosts(posts2);


            authorRepository.save(author2);
            postRepository.saveAll(posts2);

        }
    }
}
