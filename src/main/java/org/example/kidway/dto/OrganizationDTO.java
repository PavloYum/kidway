package org.example.kidway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для передачи данных организации между API и клиентом.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    private Long id;         // ID организации
    private String name;     // Название организации
    private String description; // Описание
    private Double lat;      // Координаты (широта)
    private Double lon;      // Координаты (долгота)
    private String photo;    // Ссылка на фото
}

