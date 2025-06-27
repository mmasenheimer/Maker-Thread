package com.mmasenheimer.makerthread.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // If we try to save a tag where the ID is null, JPA generates UUID and use it
    private UUID id;

    @Column(nullable = false,  unique = true)
    // We always want a unique name
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        // Comparing if another object is equal to this object
        if (o == null || getClass() != o.getClass()) return false;
        // Not an instance of this class
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        // Hashing for this class
        return Objects.hash(id, name);
    }
}
