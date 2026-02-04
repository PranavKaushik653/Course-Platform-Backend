package com.backend.courseplatform.controller;

import com.backend.courseplatform.dto.CourseResponseDTO;
import com.backend.courseplatform.service.SearchService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @GetMapping
    public Map<String, List<CourseResponseDTO>> searchCourse(@Param("q") String q) {
        return Map.of("course",searchService.search(q));
    }
}
