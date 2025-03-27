package com.team48.kidway.service;

import com.team48.kidway.dto.UserDTO;
import com.team48.kidway.dto.UserRegisterDTO;
import com.team48.kidway.model.User;
import com.team48.kidway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserRegisterDTO userRegisterDTO) {
        if (userRepository.findByEmail(userRegisterDTO.getEmail()) != null) {
            throw new RuntimeException("Пользователь с таким email уже существует");
        }

        User user = new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setSecondName(userRegisterDTO.getSecondName());
        user.setTel(userRegisterDTO.getTel());

        User savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserDTO findUserDTOByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return mapToDTO(user);
    }

    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setTel(user.getTel());
        return userDTO;
    }
}