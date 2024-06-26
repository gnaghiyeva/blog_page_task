package org.example.blog_page_task.services.impl;

import org.example.blog_page_task.dtos.articledtos.*;
import org.example.blog_page_task.helpers.SeoHelper;
import org.example.blog_page_task.models.Article;
import org.example.blog_page_task.models.Category;
import org.example.blog_page_task.repositories.ArticleRepository;
import org.example.blog_page_task.repositories.CategoryRepository;
import org.example.blog_page_task.services.ArticleService;
import org.example.blog_page_task.services.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailService emailService;

    @Override
    public List<ArticleDto> getArticles() {
        List<ArticleDto> articleDtoList = articleRepository.findAll().stream()
                .filter(x->x.getIsDeleted() == false)
                .map(article -> modelMapper.map(article, ArticleDto.class))
                .collect(Collectors.toList());
        return articleDtoList;
    }

    @Override
    public void addArticle(ArticleCreateDto articleDto) {
        Article article = modelMapper.map(articleDto, Article.class);
        Category category = categoryRepository.findById(articleDto.getCategoryId()).get();
        article.setUpdatedDate(new Date());
        article.setCreatedDate(new Date());
        article.setCategory(category);
        SeoHelper seoHelper = new SeoHelper();
        article.setSeoUrl(seoHelper.seoUrlHelper(articleDto.getTitle()));
        article.setIsDeleted(false);
        articleRepository.save(article);
    }

    @Override
    public List<ArticleHomeDto> getHomeArticles() {

        List<ArticleHomeDto> articleDtoList = articleRepository.findAll().stream()
                .filter(x->x.getIsDeleted() == false)
                .map(article -> modelMapper.map(article, ArticleHomeDto.class))
                .collect(Collectors.toList());
        return articleDtoList;
    }



    @Override
    public void updateArticle(ArticleUpdateDto articleDto) {
        Article findArticle = articleRepository.findById(articleDto.getId()).orElseThrow();
        Category category = categoryRepository.findById(articleDto.getCategoryId()).orElseThrow();
        findArticle.setId(articleDto.getId());
        findArticle.setTitle(articleDto.getTitle());
        findArticle.setDescription(articleDto.getDescription());
        findArticle.setUpdatedDate(new Date());
        findArticle.setPhotoUrl(articleDto.getPhotoUrl());
        findArticle.setCategory(category);
        SeoHelper seoHelper = new SeoHelper();
        findArticle.setSeoUrl(seoHelper.seoUrlHelper(articleDto.getTitle()));
        articleRepository.saveAndFlush(findArticle);
    }
    @Override
    public ArticleUpdateDto findUpdatedArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        ArticleUpdateDto articleUpdateDto = modelMapper.map(article, ArticleUpdateDto.class);
        return articleUpdateDto;
    }

    @Override
    public ArticleDetailDto articleDetail(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        ArticleDetailDto articleUpdateDto = modelMapper.map(article, ArticleDetailDto.class);
        return articleUpdateDto;
    }

    @Override
    public void removeArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.setIsDeleted(true);
//        articleRepository.delete(article);
        articleRepository.save(article);
    }
}
