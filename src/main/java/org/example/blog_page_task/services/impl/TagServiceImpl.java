package org.example.blog_page_task.services.impl;

import org.example.blog_page_task.dtos.tagdtos.TagCreateDto;
import org.example.blog_page_task.dtos.tagdtos.TagDto;
import org.example.blog_page_task.models.Tag;
import org.example.blog_page_task.repositories.TagRepository;
import org.example.blog_page_task.services.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired(required = true)
    private ModelMapper modelMapper;

    @Override
    public void add(TagCreateDto tagCreateDto) {
        Tag tag = modelMapper.map(tagCreateDto, Tag.class);
        tagRepository.save(tag);

    }

    @Override
    public List<TagDto> getAllTags() {
        List<TagDto> tags = tagRepository.findAll()
                .stream()
                .map(tag -> modelMapper.map(tag, TagDto.class))
                .collect(Collectors.toList());        ;
        return tags;
    }
}
