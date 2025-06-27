package com.mmasenheimer.makerthread.mappers;

import com.mmasenheimer.makerthread.domain.PostStatus;
import com.mmasenheimer.makerthread.domain.dtos.CategoryDto;
import com.mmasenheimer.makerthread.domain.dtos.CreateCategoryRequest;
import com.mmasenheimer.makerthread.domain.entities.Category;
import com.mmasenheimer.makerthread.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
// If we can't map to the target, ignore
public interface CategoryMapper {

    @Mapping(target = "postCount", source="posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    // MapStruct will implement this method

    default long calculatePostCount(List<Post> posts) {
        if(posts == null) {
            return 0;
            // If there are no posts
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus())).count();
        // Return the count of posts per person

    }
}
