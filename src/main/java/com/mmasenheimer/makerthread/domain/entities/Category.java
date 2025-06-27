package com.mmasenheimer.makerthread.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // If we try to save a category where the ID is null, JPA generates UUID and use it
    private UUID id;

    @Column(unique = true,  nullable = false)
    // There should always be a unique name
    private String name;

    @OneToMany(mappedBy = "category")
    // Post class category instance variable
    private List<Post> posts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        // Comparing if another object is equal to this object
        if (o == null || getClass() != o.getClass()) return false;
        // Not an instance of this class
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        // Hashing for the attributes
        return Objects.hash(id, name);
    }
}
