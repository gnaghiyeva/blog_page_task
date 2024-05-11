package org.example.blog_page_task.controllers;

import org.example.blog_page_task.dtos.articledtos.ArticleDto;
import org.example.blog_page_task.dtos.articledtos.ArticleHomeDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryCreateDto;
import org.example.blog_page_task.services.ArticleService;
import org.example.blog_page_task.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ArticleService articleService;
    @Autowired//neden implement olur ona baxir -> categoryserviceimpl
    private CategoryService categoryService; //123

//    @GetMapping("/")
//    public String index(Model model) {
//        List<ArticleHomeDto> homeArticles = articleService.getHomeArticles();
//        model.addAttribute("articles", homeArticles);
//        return "home";
//    }
    @GetMapping("/")
    public String index(Model model) {
        List<ArticleHomeDto> homeArticles = articleService.getHomeArticles();
        int totalArticles = homeArticles.size();
        if (totalArticles > 1) {
            // Get the last two articles
            List<ArticleHomeDto> lastTwoArticles = homeArticles.subList(totalArticles - 2, totalArticles);
            model.addAttribute("articles", lastTwoArticles);
        } else {
            // If there are less than two articles, add all articles to the model
            model.addAttribute("articles", homeArticles);
        }
        return "home";
    }
    @PostMapping("/create")
    public String Create(@ModelAttribute  CategoryCreateDto categoryCreateDto)
    {
        ArticleDto articleDto = new ArticleDto();
        categoryService.add(categoryCreateDto);
        return "Home";
    }

}
