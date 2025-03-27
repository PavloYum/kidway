package com.team48.kidway.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Long id;
    private Long organizationId; // Для передачи ID организации
}