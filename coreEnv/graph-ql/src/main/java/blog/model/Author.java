package blog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Date birthDay;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "author")
    private Set<Post> posts;
}
