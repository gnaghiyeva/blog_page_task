package org.example.blog_page_task.dtos.articledtos;

/*
//dto niye var  meqale yaratdigimiz anda bezi melumatlar varki

hemin anda daxil edirik, bezilerini hemin anda daxil etmirik.
bezen oxuyanda meqaleni ozunu oxuyuruq ama ana sehifede meqale ozu olmur sadece basliqlar var
 bu melumatlar atilir dto icine deyirikki bize filan melumatlari goster
 */

import lombok.Getter;
import lombok.Setter;
import org.example.blog_page_task.dtos.categorydtos.CategoryDto;

import java.util.Date;

@Getter
@Setter
public class ArticleDto {
//create update biz yazmiriq
// amma title description falan ozumuz yaziriq
    private Long id;
    private String title;//*
    private String photoUrl;
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    private CategoryDto category;
}
