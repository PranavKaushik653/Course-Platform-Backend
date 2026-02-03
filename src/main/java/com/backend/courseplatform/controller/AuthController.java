package com.backend.courseplatform.controller;

import com.backend.courseplatform.dto.LoginRequestDTO;
import com.backend.courseplatform.dto.LoginResponseDTO;
import com.backend.courseplatform.dto.UserResponseDTO;
import com.backend.courseplatform.entity.User;
import com.backend.courseplatform.service.UserService;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Data
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @RequestBody User request
    )
    {
        UserResponseDTO response=userService.register(request.getEmail(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO response=userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(response);
    }
}
