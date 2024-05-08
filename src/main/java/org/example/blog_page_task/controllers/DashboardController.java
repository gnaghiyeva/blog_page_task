package org.example.blog_page_task.controllers;

import org.example.blog_page_task.dtos.articledtos.ArticleCreateDto;
import org.example.blog_page_task.dtos.articledtos.ArticleDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryCreateDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryDto;
import org.example.blog_page_task.dtos.tagdtos.TagCreateDto;
import org.example.blog_page_task.dtos.tagdtos.TagDto;
import org.example.blog_page_task.services.ArticleService;
import org.example.blog_page_task.services.CategoryService;
import org.example.blog_page_task.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/admin")
    public String index() {

        return "/dashboard/home";
    }

    @GetMapping("/admin/category")
    public String category(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/dashboard/category";
    }

    @GetMapping("/admin/category/category-create")
    public String addCategory() {
        return "/dashboard/category-create";
    }

    @PostMapping("/admin/category/create")
    public String addCategory(@ModelAttribute CategoryCreateDto categoryCreateDto) {
        categoryService.add(categoryCreateDto);
        return "redirect:/admin/category";
    }

    //Article


    @GetMapping("/admin/article")
    public String articleGet(Model model)
    {
        List<ArticleDto> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        return "/dashboard/article";
    }

    @GetMapping("/admin/article/article-create")
    public String articleCreate(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/dashboard/article-create";
    }


    @PostMapping("/admin/article/create")
    public String articleCreate(@ModelAttribute ArticleCreateDto articleDto)
    {
        articleService.addArticle(articleDto);
        return "redirect:/admin/article";
    }

    //Tag
    @Autowired
    private TagService tagService;

    @GetMapping("/admin/tag")
    public String tag(Model model) {
        List<TagDto> tags = tagService.getAllTags();
        model.addAttribute("tags", tags);
        return "/dashboard/tag";
    }

    @GetMapping("/admin/tag/tag-create")
    public String addTagForm(Model model) {
        model.addAttribute("tagCreateDto", new TagCreateDto());
        return "/dashboard/tag-create";
    }

    @PostMapping("/admin/tag/create")
    public String addTag(@ModelAttribute TagCreateDto tagCreateDto) {
        tagService.add(tagCreateDto);
        return "redirect:/admin/tag";
    }


}

