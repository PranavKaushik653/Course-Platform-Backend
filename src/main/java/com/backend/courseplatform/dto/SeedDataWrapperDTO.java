package com.backend.courseplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class SeedDataWrapperDTO {
    private List<CourseDTO> courses;
}
