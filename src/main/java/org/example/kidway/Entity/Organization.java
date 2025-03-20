package org.example.kidway.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Класс-сущность для организаций (школы, секции, сады и т. д.)
 */
@Entity
@Data
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент ID
    private Long id;

    @Column(nullable = false) // Название обязательно
    private String name;
    private String description; // Описание организации
    private Double lat; // Широта (для карты)
    private Double lon; // Долгота (для карты)
    private String photo; // Ссылка на фото организации
    private Long userId;


    //@ManyToOne
    //@JoinColumn(name = "user_id", nullable = false) // Связь с пользователем (владелец)
    //private User user;
    //
}
