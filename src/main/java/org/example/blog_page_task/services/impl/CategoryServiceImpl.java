package org.example.blog_page_task.services.impl;

import org.example.blog_page_task.dtos.categorydtos.CategoryCreateDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryDto;
import org.example.blog_page_task.models.Category;
import org.example.blog_page_task.repositories.CategoryRepository;
import org.example.blog_page_task.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//123
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired(required = true)
    private ModelMapper modelMapper;

    @Override
    public void add(CategoryCreateDto categoryCreateDto) {
        Category category = modelMapper.map(categoryCreateDto,Category.class);
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List <CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(category-> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());

        return categories;
    }
}
