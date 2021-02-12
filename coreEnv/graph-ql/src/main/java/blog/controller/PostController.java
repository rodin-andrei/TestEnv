package blog.controller;

import blog.model.Post;
import blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping(path = "all")
    public List<Post> all() {
        return postService.getAll();
    }

    @GetMapping(path = "{id}")
    public Post post(Long id) {
        return postService.getById(id);
    }

    @PostMapping(path = "create")
    public Post create(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
