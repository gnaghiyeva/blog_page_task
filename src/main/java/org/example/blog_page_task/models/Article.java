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
    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;//*

    private String photoUrl;//*
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    private Boolean isDeleted;

    //category ve article arasinda elaqe
    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "article_tags", joinColumns = @JoinColumn(name = "tags",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "articles", referencedColumnName = "id"))
    private List<Tag> tags;
}


