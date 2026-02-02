package com.backend.courseplatform.service;


import com.backend.courseplatform.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(String email, String password);
}
