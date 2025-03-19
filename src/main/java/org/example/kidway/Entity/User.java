package org.example.kidway.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Класс-сущность для представления пользователей в базе данных.
 */
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация идентификатора
    private Long id;

    @Column(nullable = false, unique = true) // Email должен быть уникальным и обязательным
    private String email;

    @Column(nullable = false) // Пароль обязательный
    private String password;

    private String firstName; // Имя пользователя
    private String secondName; // Фамилия пользователя
    private String tel; // Контактный номер телефона
}

