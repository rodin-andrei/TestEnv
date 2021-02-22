package com.unifun.spamBeeper.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"filters"})
public class Company {
    @ManyToOne
    @JoinColumn(name = "prompt_id", nullable = false)
    protected Prompt prompt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int priority;

    private boolean active;

    private boolean isDefault;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<CompanyFilter> filters;

    private boolean earlyMedia;
}
