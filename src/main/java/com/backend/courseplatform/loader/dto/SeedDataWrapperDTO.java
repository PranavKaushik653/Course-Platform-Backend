package com.backend.courseplatform.loader.dto;

import com.backend.courseplatform.entity.Topics;
import lombok.Data;

import java.util.List;

@Data
public class SeedDataWrapperDTO {
    private List<CourseDTO> courses;
}
