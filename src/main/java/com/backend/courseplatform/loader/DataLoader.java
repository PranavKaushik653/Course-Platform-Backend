package com.backend.courseplatform.loader;

import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.entity.Subtopics;
import com.backend.courseplatform.entity.Topics;
import com.backend.courseplatform.loader.dto.CourseDTO;
import com.backend.courseplatform.loader.dto.SeedDataWrapperDTO;
import com.backend.courseplatform.loader.dto.SubtopicDTO;
import com.backend.courseplatform.loader.dto.TopicsDTO;
import com.backend.courseplatform.repository.CourseRepository;
import lombok.Data;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Data
@Component
public class DataLoader implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(CourseRepository courseRepository,
                      ObjectMapper objectMapper) {
        this.courseRepository = courseRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public void run(String @NonNull ... strings) throws Exception {
        if (courseRepository.count() > 0) {
            System.out.println("Seed data already exists");
            return;
        }
        InputStream stream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("seed_data/courses.json");

        if(stream == null) {
            throw new Exception("Could not load seed data");
        }
        List<CourseDTO> courseDTOs =
                objectMapper
                        .readValue(stream, SeedDataWrapperDTO.class)
                        .getCourses();

        //this is for DTO to Entity mapping
        for(CourseDTO c: courseDTOs) {
            Course course = new Course();
            course.setId(c.getId());
            course.setTitle(c.getTitle());
            course.setDescription(c.getDescription());

            for(TopicsDTO t: c.getTopics()) {
                Topics topics=new Topics();
                topics.setId(t.getId());
                topics.setTitle(t.getTitle());
                topics.setCourse(course);

                for(SubtopicDTO s: t.getSubtopics()) {
                    Subtopics subtopics=new Subtopics();
                    subtopics.setId(s.getId());
                    subtopics.setTitle(s.getTitle());
                    subtopics.setContent(s.getContent());
                    subtopics.setTopic(topics);

                    topics.getSubtopics().add(subtopics);
                }
                course.getTopics().add(topics);
            }
            courseRepository.save(course);
        }
        System.out.println("Seed data loaded successfully");
    }
}
