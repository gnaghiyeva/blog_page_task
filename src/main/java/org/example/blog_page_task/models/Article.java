package org.example.blog_page_task.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;//*
    private String subTitle;//*
    private String description;//*
    private String photoUrl;//*
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;


    //category ve article arasinda elaqe
    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Tag> tags;
}

