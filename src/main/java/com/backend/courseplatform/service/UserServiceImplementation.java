package com.backend.courseplatform.service;

import com.backend.courseplatform.dto.UserResponseDTO;
import com.backend.courseplatform.entity.User;
import com.backend.courseplatform.repository.UserRepository;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
