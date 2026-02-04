package com.backend.courseplatform.service;

import com.backend.courseplatform.dto.CourseResponseDTO;
import com.backend.courseplatform.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final CourseRepository courseRepository;
    public SearchService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseResponseDTO> search(String query){
        return courseRepository.searchCourse(query);
    }
}
