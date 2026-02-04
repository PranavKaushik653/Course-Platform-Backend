package com.backend.courseplatform.service;

import com.backend.courseplatform.dto.ProgressResponseDTO;

public interface ProgressService {
    ProgressResponseDTO getProgressResponseDTO(String courseId);
}
