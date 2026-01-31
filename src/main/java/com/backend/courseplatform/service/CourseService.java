package com.backend.courseplatform.service;


import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.loader.dto.CourseDTO;
import com.backend.courseplatform.loader.dto.CourseResponseDTO;
import com.backend.courseplatform.loader.dto.SubtopicDTO;
import com.backend.courseplatform.loader.dto.TopicsDTO;
import com.backend.courseplatform.repository.CourseRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findCourseSummaries();
    }
    public CourseDTO getCourseById(String courseId) {
        Course course=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course not found"));

        List<TopicsDTO> topicDTOs = course.getTopics().stream()
                .map(t -> new TopicsDTO(
                        t.getId(),
                        t.getTitle(),
                        t.getSubtopics().stream()
                                .map(s -> new SubtopicDTO(
                                        s.getId(),
                                        s.getTitle(),
                                        s.getContent()
                                ))
                                .toList()
                ))
                .toList();

        return new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                topicDTOs
        );
    }
}
