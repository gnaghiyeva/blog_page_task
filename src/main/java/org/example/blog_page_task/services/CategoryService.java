package org.example.blog_page_task.services;

import org.example.blog_page_task.dtos.categorydtos.CategoryCreateDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryDto;
import org.example.blog_page_task.models.Article;

import java.util.List;

//metodlar burda yazilir
public interface CategoryService {
    //DTO
//    void add(Article article);
    void add(CategoryCreateDto categoryCreateDto);
//bu deyismeyecek
    List<CategoryDto> getAllCategories();
}
