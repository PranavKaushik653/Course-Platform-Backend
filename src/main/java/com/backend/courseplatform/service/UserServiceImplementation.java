package com.backend.courseplatform.service;

import com.backend.courseplatform.dto.LoginResponseDTO;
import com.backend.courseplatform.dto.UserResponseDTO;
import com.backend.courseplatform.entity.User;
import com.backend.courseplatform.repository.UserRepository;
import com.backend.courseplatform.security.JwtUtil;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public UserResponseDTO register(String email, String password) {
        if(userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email aready registered");
        }
        User user=new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        User savedUser=userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getEmail(),
                "User registered successfully"
        );
    }

    @Override
    public LoginResponseDTO login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponseDTO(
                token,
                user.getEmail(),
                jwtUtil.getExpirationTime()
        );
    }
}
