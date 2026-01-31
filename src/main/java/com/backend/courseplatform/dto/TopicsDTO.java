package com.backend.courseplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopicsDTO {
    public String id;
    public String title;
    public List<SubtopicDTO> subtopics;
}
