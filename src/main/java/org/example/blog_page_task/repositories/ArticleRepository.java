package org.example.blog_page_task.repositories;

import org.example.blog_page_task.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
