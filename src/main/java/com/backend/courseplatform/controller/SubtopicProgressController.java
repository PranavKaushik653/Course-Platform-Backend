package com.backend.courseplatform.controller;

import com.backend.courseplatform.entity.SubTopicProgress;
import com.backend.courseplatform.service.SubtopicProgressService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subtopics")
@Data
public class SubtopicProgressController {
    private final SubtopicProgressService subtopicProgressService;

    @PostMapping
            ("/{subtopicId}/complete")
    public ResponseEntity<?> completeSubtopic(
            @PathVariable String subtopicId
    ) {
        subtopicProgressService.completeSubtopic(subtopicId);

        return ResponseEntity.ok(
                java.util.Map.of("message", "Subtopic marked as completed")
        );
    }
}
