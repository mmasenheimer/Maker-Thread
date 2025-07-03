package com.mmasenheimer.makerthread.domain.entities;

import com.mmasenheimer.makerthread.domain.PostStatus;
import com.mmasenheimer.makerthread.domain.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // If we try to save a post where the ID is null, JPA generates UUID and use it
    private UUID id;

    @Column(nullable = false)
    // Posts should always have a title
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    // Posts should always have content and allows column variable length
    private String content;

    @Column(nullable = false)
    // Posts will always have a status
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @Column(nullable = false)
    // Always want a post to have an estimated reading time
    private Integer readingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    // Loading post authors when they are explicitly accessed
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name="post_id"),
            // Column that refers to the post entity
            inverseJoinColumns = @JoinColumn(name = "tag_id")
            // Column refering to the tag entity
    )
    private Set<Tag> tags = new HashSet<>();

    @Column(nullable = false)
    // Always want to have a created at time
    private LocalDateTime createdAt;

    @Column(nullable = false)
    // There should always be an updated time
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        // Comparing if other object equals this object
        if (o == null || getClass() != o.getClass()) return false;
        // Not an instance of this class
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && status == post.status && Objects.equals(readingTime, post.readingTime) && Objects.equals(createdAt, post.createdAt) && Objects.equals(updatedAt, post.updatedAt);
    }

    @Override
    public int hashCode() {
        // Hash code for this class
        return Objects.hash(id, title, content, status, readingTime, createdAt, updatedAt);
    }

    @PrePersist
    // Should be executed before an entity is inserted into the database
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        // When a post is created, updated and created at times are the same

    }

    @PreUpdate
    // Should be executed before an entity is updated into the database
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
