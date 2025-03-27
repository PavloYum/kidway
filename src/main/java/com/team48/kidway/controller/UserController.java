package com.team48.kidway.controller;

import com.team48.kidway.dto.UserDTO;
import com.team48.kidway.dto.UserLoginDTO;
import com.team48.kidway.dto.UserRegisterDTO;
import com.team48.kidway.security.JwtUtil;
import com.team48.kidway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        UserDTO newUser = userService.registerUser(userRegisterDTO);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        UserDTO existingUser = userService.findUserDTOByEmail(userLoginDTO.getEmail());
        if (existingUser == null || !passwordEncoder.matches(userLoginDTO.getPassword(), userService.findByEmail(userLoginDTO.getEmail()).getPassword())) {
            return ResponseEntity.status(401).body("Неверный email или пароль");
        }
        String token = jwtUtil.generateToken(userLoginDTO.getEmail());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserDTO user = userService.findUserDTOByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}