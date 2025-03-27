package com.team48.kidway.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Children")
@Data
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;
    private Double weight;
    private Double height;
    private String hobbies;

    @ManyToMany(mappedBy = "children")
    private Set<User> users = new HashSet<>();
}