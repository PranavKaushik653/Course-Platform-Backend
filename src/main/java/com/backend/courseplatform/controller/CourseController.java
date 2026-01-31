package com.backend.courseplatform.controller;

import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.loader.dto.CourseDTO;
import com.backend.courseplatform.loader.dto.CourseResponseDTO;
import com.backend.courseplatform.service.CourseService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Data
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    //to return all the courses
    @GetMapping
    public Map<String , List<CourseResponseDTO>> getAllCourses(){
        List<CourseResponseDTO>courses = courseService.getAllCourses();
        return Map.of("courses",courses);
    }

    //it will return a single course corresponding to the id
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }
}
