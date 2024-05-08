package org.example.blog_page_task.repositories;

import org.example.blog_page_task.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
