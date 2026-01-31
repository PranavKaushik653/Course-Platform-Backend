package com.backend.courseplatform.loader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TopicsDTO {
    public String id;
    public String title;
    public List<SubtopicDTO> subtopics;
}
