package com.backend.courseplatform.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subtopics")
public class Subtopics {
    @Id
    private String id;

    private String title;

    @Column(columnDefinition = "text")
    private String content; // markdown

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topics topic;

}
