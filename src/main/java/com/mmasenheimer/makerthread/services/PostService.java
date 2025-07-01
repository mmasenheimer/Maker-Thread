package com.mmasenheimer.makerthread.services;


import com.mmasenheimer.makerthread.domain.entities.Post;
import com.mmasenheimer.makerthread.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
}
