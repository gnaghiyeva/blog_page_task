package org.example.blog_page_task.controllers;

import org.example.blog_page_task.dtos.articledtos.ArticleDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryCreateDto;
import org.example.blog_page_task.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired//neden implement olur ona baxir -> categoryserviceimpl
    private CategoryService categoryService; //123

    @GetMapping("/")
    public String index() {
//        CategoryCreateDto categoryCreateDto = new CategoryCreateDto();
//        categoryCreateDto.setName("Salam");
//        categoryService.add(categoryCreateDto);
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
