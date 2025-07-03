package com.mmasenheimer.makerthread.services;


import com.mmasenheimer.makerthread.domain.CreatePostRequest;
import com.mmasenheimer.makerthread.domain.UpdatePostRequest;
import com.mmasenheimer.makerthread.domain.entities.Post;
import com.mmasenheimer.makerthread.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);

    void deletePost(UUID id);
}
