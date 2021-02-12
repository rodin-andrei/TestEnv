package blog.controller;

import blog.model.Comment;
import blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping(path = "all")
    public List<Comment> all() {
        return commentService.getAll();
    }

    @GetMapping(path = "{id}")
    public Comment comment(Long id) {
        return commentService.getById(id);
    }

    @PostMapping(path = "create")
    public Comment create(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }
}
