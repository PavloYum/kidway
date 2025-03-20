package org.example.kidway.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.kidway.Entity.User;
import org.example.kidway.dto.UserDTO;
import org.example.kidway.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Создать пользователя
    public User createUser(UserDTO userDTO) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setTel(userDTO.getTel());
        return userRepository.save(user);
    }

    // Получить всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Получить пользователя по ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
    }

    // Обновить данные пользователя
    public User updateUser(Long id, UserDTO userDTO) {
        User user = getUserById(id);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setTel(userDTO.getTel());
        return userRepository.save(user);
    }

    // Удалить пользователя
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}

