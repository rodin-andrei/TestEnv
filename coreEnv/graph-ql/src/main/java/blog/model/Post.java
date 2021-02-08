package blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    @JsonIgnore
    private Author author;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private Set<Comment> comments;
}
