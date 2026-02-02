package com.backend.courseplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseDTO {
    private String id;
    private String title;
    private String description;
    private List<TopicsDTO> topics;
}
