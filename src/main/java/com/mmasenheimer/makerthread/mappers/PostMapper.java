package com.mmasenheimer.makerthread.mappers;

import com.mmasenheimer.makerthread.domain.CreatePostRequest;
import com.mmasenheimer.makerthread.domain.UpdatePostRequest;
import com.mmasenheimer.makerthread.domain.dtos.CreatePostRequestDto;
import com.mmasenheimer.makerthread.domain.dtos.PostDto;
import com.mmasenheimer.makerthread.domain.dtos.UpdatePostRequestDto;
import com.mmasenheimer.makerthread.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
