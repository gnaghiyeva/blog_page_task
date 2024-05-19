package org.example.blog_page_task.controllers;

import org.example.blog_page_task.dtos.articledtos.ArticleDetailDto;
import org.example.blog_page_task.repositories.ArticleRepository;
import org.example.blog_page_task.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("detail/{id}/{seoUrl}")
    public String detail(@PathVariable Long id, Model model)
    {
        ArticleDetailDto articleDetail = articleService.articleDetail(id);
        model.addAttribute("article",articleDetail);
        return "detail";
    }
}
