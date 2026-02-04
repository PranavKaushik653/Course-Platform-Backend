package com.backend.courseplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgressResponseDTO {
    private long totalSubjects;
    private long completedSubjects;
    private double progressPercentage;
}
