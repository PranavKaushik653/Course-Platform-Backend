package com.backend.courseplatform.repository;

import com.backend.courseplatform.entity.Subtopics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtopicsRepository extends JpaRepository<Subtopics, String> {
    long countByTopic_Course_Id(String courseId);

}
