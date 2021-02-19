package com.unifun.spamBeeper.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class CompanyFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String condition;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonManagedReference
    private Company company;
}
