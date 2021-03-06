package blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.jmx.export.annotation.ManagedResource;

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
@EqualsAndHashCode(exclude = {"posts","comments"})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Date birthDay;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    @JsonBackReference
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "author")
    @JsonBackReference
    private Set<Post> posts;
}
