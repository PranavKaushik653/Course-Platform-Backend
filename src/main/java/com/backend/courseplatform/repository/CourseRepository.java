package com.backend.courseplatform.repository;

import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.loader.dto.CourseResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("""
    SELECT new com.backend.courseplatform.loader.dto.CourseResponseDTO(
                       c.id,
                       c.title,
                       c.description,
                       COUNT(DISTINCT t.id),
                       COUNT(s.id)
                   )
                   FROM Course c
                   LEFT JOIN c.topics t
                   LEFT JOIN t.subtopics s
                   GROUP BY c.id, c.title, c.description

""")
    List<CourseResponseDTO> findCourseSummaries();

    @Query("""
    SELECT DISTINCT new com.backend.courseplatform.loader.dto.CourseResponseDTO(
                       c.id,
                       c.title,
                       c.description,
                       COUNT(DISTINCT t.id),
                       COUNT(s.id)
                   )
                   FROM Course c
                   LEFT JOIN c.topics t
                   LEFT JOIN t.subtopics s
                   WHERE
                        LOWER(c.title) LIKE LOWER (CONCAT('%', :q, '%'))
                         OR LOWER(c.description) LIKE LOWER(CONCAT('%', :q, '%'))
                                OR LOWER(t.title) LIKE LOWER(CONCAT('%', :q, '%'))
                                OR LOWER(s.title) LIKE LOWER(CONCAT('%', :q, '%'))
                                OR LOWER(s.content) LIKE LOWER(CONCAT('%', :q, '%'))
                            GROUP BY c.id, c.title, c.description
""")
    List<CourseResponseDTO> searchCourse(@Param("q") String q);
}
