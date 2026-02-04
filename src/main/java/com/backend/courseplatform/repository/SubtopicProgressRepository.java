package com.backend.courseplatform.repository;

import com.backend.courseplatform.entity.SubTopicProgress;
import com.backend.courseplatform.entity.Subtopics;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubtopicProgressRepository
        extends JpaRepository<SubTopicProgress, Long> {

    Optional<SubTopicProgress> findByUser_IdAndSubtopic_Id(
            Long userId,
            String subtopicId
    );

    long countByUser_IdAndSubtopic_Topic_Course_IdAndCompleted(
            Long userId,
            String courseId,
            Boolean completed
    );
}


