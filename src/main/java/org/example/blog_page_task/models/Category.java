package org.example.blog_page_task.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
//bir category bir nece meqaleye aid ola biler,
//amma bir meqalenin yalniz bir category-si var
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "articles", nullable = true)
    private List<Article> articles;
}


