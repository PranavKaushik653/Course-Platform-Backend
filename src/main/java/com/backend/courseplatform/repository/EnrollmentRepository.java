package com.backend.courseplatform.repository;

import com.backend.courseplatform.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByUser_IdAndCourse_Id(Long userId, String courseId);

    Optional<Enrollment> findByUser_IdAndCourse_Id(Long userId, String courseId);
}
