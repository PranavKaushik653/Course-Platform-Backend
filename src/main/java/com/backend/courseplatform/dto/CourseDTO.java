package com.backend.courseplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private String id;
    private String title;
    private String description;
    private List<TopicsDTO> topics;
}
