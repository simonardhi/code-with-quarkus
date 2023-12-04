package org.briix.test.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.briix.test.models.Tag;

@ApplicationScoped
public class TagRepository implements PanacheRepository<Tag> {
}
