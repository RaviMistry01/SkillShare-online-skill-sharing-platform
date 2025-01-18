package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;


    private String courseTitle;
    private String description;
    private int duration;
    private double coursePrice;

    @ManyToOne
    @JoinColumn(name="instructor_id",nullable = false)
    private User Instuctor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToMany(mappedBy = "course")
    private Set <Enrollment> enrollments;


    @PrePersist
    protected void onCreate(){
        created_at = new Date();
        updated_at = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updated_at = new Date();
    }

    
}
