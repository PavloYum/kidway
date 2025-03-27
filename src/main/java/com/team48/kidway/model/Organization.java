package com.team48.kidway.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Organizations")
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double lat;
    private Double longi;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
