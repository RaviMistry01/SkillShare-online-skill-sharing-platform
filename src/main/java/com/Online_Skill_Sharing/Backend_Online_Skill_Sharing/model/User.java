package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(unique = true)
    private String username;

    @Column(unique=true)
    private String email;
    private String password;
    private String fullname;
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "user")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at",updatable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updated_at;
    

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
