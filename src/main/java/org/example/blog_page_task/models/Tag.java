package org.example.blog_page_task.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tags")
//bir article bir nece tag-i ola biler,
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "article_tags", joinColumns = @JoinColumn(name = "tags",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "articles", referencedColumnName = "id"))
    private List<Article> articles;
}
