package com.backend.courseplatform.service;


import com.backend.courseplatform.dto.LoginResponseDTO;
import com.backend.courseplatform.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(String email, String password);
    LoginResponseDTO login(String email, String password);
}
