package org.briix.test.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Tag extends PanacheEntity {
    public String label;

    @ManyToMany(mappedBy = "tags")
    public List<Post> posts;
}
