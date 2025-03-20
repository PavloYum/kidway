package org.example.kidway.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrganizationDTO {
    @NotBlank(message = "Название обязательно")
    private String name;

    private String description;

    @NotNull(message = "Координаты обязательны")
    private Double latitude;

    @NotNull(message = "Координаты обязательны")
    private Double longitude;

    private String photoUrl;

    //@NotNull(message = "ID пользователя обязателен")
    //private Long userId;
}

