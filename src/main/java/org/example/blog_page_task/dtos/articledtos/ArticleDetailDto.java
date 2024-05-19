package org.example.blog_page_task.dtos.articledtos;

import lombok.Getter;
import lombok.Setter;
import org.example.blog_page_task.dtos.categorydtos.CategoryDto;

import java.util.Date;

@Getter
@Setter
public class ArticleDetailDto {
    private Long id;
    private String title;
    private String subTitle;
    private String description;
    private String photoUrl;
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    private CategoryDto category;
}
