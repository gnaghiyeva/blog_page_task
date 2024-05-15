package org.example.blog_page_task.dtos.articledtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateDto {
    private Long id;
    private String title;//*
    private String subTitle;//*
    private String description;//*
    private String photoUrl;//*
    private Long categoryId;
}
