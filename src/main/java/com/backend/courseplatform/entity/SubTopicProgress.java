package com.backend.courseplatform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subtopic_progress", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","subtopic_id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTopicProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Enrollment enrollment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtopic_id", nullable = false)
    private Subtopics subtopic;

    @Column(nullable = false)
    private Boolean completed = false;
}
