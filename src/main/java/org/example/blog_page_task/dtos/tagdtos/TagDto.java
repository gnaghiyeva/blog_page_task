package org.example.blog_page_task.dtos.tagdtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TagDto {
    private Long id;
    private String name;
}
