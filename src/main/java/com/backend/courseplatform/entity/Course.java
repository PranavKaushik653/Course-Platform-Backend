package com.backend.courseplatform.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="course")
public class Course {
    @Id
    private String id;
    private String title;

    @Column(length = 1000)
    private String description;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Topics> topics=new ArrayList<>();
}
