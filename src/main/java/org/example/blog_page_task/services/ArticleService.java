package org.example.blog_page_task.services;

import org.example.blog_page_task.dtos.articledtos.ArticleCreateDto;
import org.example.blog_page_task.dtos.articledtos.ArticleDto;
import org.example.blog_page_task.dtos.articledtos.ArticleHomeDto;
import org.example.blog_page_task.dtos.articledtos.ArticleUpdateDto;

import java.util.List;

public interface ArticleService {

    List<ArticleDto> getArticles();

    void addArticle(ArticleCreateDto articleDto);
    List<ArticleHomeDto> getHomeArticles();

    void removeArticle(Long articleId);

    void updateArticle(ArticleUpdateDto articleDto);

    ArticleUpdateDto findUpdatedArticle(Long id);
}
