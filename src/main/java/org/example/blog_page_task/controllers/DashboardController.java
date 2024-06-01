package org.example.blog_page_task.controllers;

import org.example.blog_page_task.dtos.articledtos.ArticleCreateDto;
import org.example.blog_page_task.dtos.articledtos.ArticleDto;
import org.example.blog_page_task.dtos.articledtos.ArticleUpdateDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryCreateDto;
import org.example.blog_page_task.dtos.categorydtos.CategoryDto;
import org.example.blog_page_task.dtos.roledtos.RoleDto;
import org.example.blog_page_task.dtos.tagdtos.TagCreateDto;
import org.example.blog_page_task.dtos.tagdtos.TagDto;
import org.example.blog_page_task.dtos.userdtos.UserAddRoleDto;
import org.example.blog_page_task.dtos.userdtos.UserDashboardListDto;
import org.example.blog_page_task.dtos.userdtos.UserDto;
import org.example.blog_page_task.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class DashboardController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads";

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
    public String articleCreate(@ModelAttribute ArticleCreateDto articleDto, @RequestParam("image") MultipartFile image) throws IOException {
        UUID rand = UUID.randomUUID();
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, rand+image.getOriginalFilename());
        fileNames.append(rand+image.getOriginalFilename());
        Files.write(fileNameAndPath, image.getBytes());
        articleDto.setPhotoUrl(rand+image.getOriginalFilename());
        articleService.addArticle(articleDto);
        return "redirect:/admin/article";
    }

    @GetMapping("/admin/article/remove/{id}")
    public String removeArticle(@ModelAttribute @PathVariable Long id){
        articleService.removeArticle(id);
        return "redirect:/admin/article";
    }

    @GetMapping("/admin/article/update/{id}")
    public String updateArticle(@ModelAttribute @PathVariable Long id, Model model){
        ArticleUpdateDto articleUpdateDto = articleService.findUpdatedArticle(id);
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("article", articleUpdateDto);
        return "dashboard/article/update";
    }

    @PostMapping("/admin/article/update")
    public String updateArticle(@ModelAttribute ArticleUpdateDto articleUpdateDto){
        articleService.updateArticle(articleUpdateDto);
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


    @GetMapping("/admin/users")
    public String getUsers(Model model) {
        List<UserDashboardListDto> userList = userService.getDashboardUsers();
        model.addAttribute("users",userList);
        return "/dashboard/auth/user-list";
    }

    @GetMapping("/admin/users/role/{id}")
    public String addRole(@PathVariable Long id, Model model) {
        List<RoleDto> roles = roleService.getRoles();
        UserDto user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "/dashboard/auth/user-role";
    }

    @PostMapping("/admin/users/addrole")
    public String addRole(UserAddRoleDto addRoleDto)
    {
        userService.addRole(addRoleDto);
        return "/dashboard/auth/user-list";
    }

}

