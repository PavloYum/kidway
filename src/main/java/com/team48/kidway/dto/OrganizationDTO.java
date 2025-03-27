package com.team48.kidway.dto;

import lombok.Data;

@Data
public class OrganizationDTO {
    private Long id;
    private String name;
    private String description;
    private Double lat;
    private Double longi;
    private String photo;
    private Long userId; // Для передачи ID пользователя
}