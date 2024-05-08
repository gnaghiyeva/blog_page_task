package org.example.blog_page_task.services;

import org.example.blog_page_task.dtos.tagdtos.TagCreateDto;
import org.example.blog_page_task.dtos.tagdtos.TagDto;

import java.util.List;

public interface TagService {
    void add(TagCreateDto tagCreateDto);

    List<TagDto> getAllTags();

}
