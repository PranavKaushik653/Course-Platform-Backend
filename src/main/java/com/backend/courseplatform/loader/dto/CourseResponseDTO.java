package com.backend.courseplatform.loader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponseDTO {
    private String id;
    private String title;
    private String description;
    private long topicCount;
    private long subtopicCount;
}
