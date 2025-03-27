package com.team48.kidway.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Location")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}