package org.example.kidway.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс-сущность для организаций (школы, секции, сады и т. д.)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Связь с пользователем (владелец)
    private User user;
}
