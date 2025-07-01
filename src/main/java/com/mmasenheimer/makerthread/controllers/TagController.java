package com.mmasenheimer.makerthread.controllers;

import com.mmasenheimer.makerthread.domain.dtos.CreateTagsRequest;
import com.mmasenheimer.makerthread.domain.dtos.TagDto;
import com.mmasenheimer.makerthread.domain.entities.Tag;
import com.mmasenheimer.makerthread.mappers.TagMapper;
import com.mmasenheimer.makerthread.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        List<Tag> tags = tagService.getTags();
        List<TagDto> tagRespons = tags.stream().map(tagMapper::toTagResponse).toList();
        return ResponseEntity.ok(tagRespons);

    }

    @PostMapping
    public ResponseEntity<List<TagDto>> createTags(@RequestBody CreateTagsRequest createTagsRequest) {
        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());

        List<TagDto> createdTagRespons = savedTags.stream().map(tagMapper::toTagResponse).toList();

        return new ResponseEntity<> (
                createdTagRespons,
                HttpStatus.CREATED
        );

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();

    }
}
