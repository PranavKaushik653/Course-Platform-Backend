package com.backend.courseplatform.repository;

import com.backend.courseplatform.loader.dto.CourseResponseDTO;
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
