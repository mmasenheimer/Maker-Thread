package com.mmasenheimer.makerthread.mappers;

import com.mmasenheimer.makerthread.domain.dtos.PostDto;
import com.mmasenheimer.makerthread.domain.entities.Category;
import com.mmasenheimer.makerthread.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "author")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);
}
