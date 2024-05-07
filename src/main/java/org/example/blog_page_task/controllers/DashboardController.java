package org.example.blog_page_task.controllers;

import org.example.blog_page_task.dtos.categorydtos.CategoryDto;
import org.example.blog_page_task.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    private CategoryService categoryService;

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

    
}
