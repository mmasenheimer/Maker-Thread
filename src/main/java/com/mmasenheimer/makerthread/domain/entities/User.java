package com.mmasenheimer.makerthread.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // If we try to save a user where the ID is null, JPA generates UUID and use it
    private UUID id;

    @Column(nullable = false, unique = true)
    // Always want an email provided that is unique
    private String email;

    @Column(nullable = false)
    private String password;
    // Always want a password per user

    @Column(nullable = false)
    private String name;
    // Always want a password per user

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    // When a user is deleted, all their posts will also be deleted
    private List<Post> posts = new ArrayList<>();
    // Look for author configuration

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Always want a time created at

    @Override
    public boolean equals(Object o) {
        // Comparing to see if an object equals this class
        if (o == null || getClass() != o.getClass()) return false;
        // Not an instance of this class
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        // Hashing for this class
        return Objects.hash(id, email, password, name, createdAt);
    }

    @PrePersist
    // This method should be executed before an entity is inserted into the db
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        // The date created will populate the createdAt variable

    }
}
