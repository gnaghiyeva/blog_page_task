package org.example.blog_page_task.dtos.articledtos;

import lombok.Getter;
import lombok.Setter;
import org.example.blog_page_task.models.Category;
@Getter
@Setter
public class ArticleCreateDto {
    private String title;//*
    private String subTitle;//*
    private String description;//*
    private String photoUrl;//*
    private Long categoryId;
}
