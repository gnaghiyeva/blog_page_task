package org.example.blog_page_task.services;

import org.example.blog_page_task.dtos.articledtos.*;

import java.util.List;

public interface ArticleService {

    List<ArticleDto> getArticles();

    void addArticle(ArticleCreateDto articleDto);
    List<ArticleHomeDto> getHomeArticles();

    void removeArticle(Long articleId);

    void updateArticle(ArticleUpdateDto articleDto);

    ArticleUpdateDto findUpdatedArticle(Long id);

    ArticleDetailDto articleDetail(Long id);
}
