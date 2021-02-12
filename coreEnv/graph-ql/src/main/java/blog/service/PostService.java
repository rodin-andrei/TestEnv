package blog.service;

import blog.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();

    Post createPost(Post author);

    Post getById(Long id);
}
