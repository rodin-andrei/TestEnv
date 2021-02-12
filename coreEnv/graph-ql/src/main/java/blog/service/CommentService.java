package blog.service;

import blog.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();

    Comment createComment(Comment comment);

    Comment getById(Long id);
}
