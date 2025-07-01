package com.mmasenheimer.makerthread.services.impl;

import com.mmasenheimer.makerthread.domain.entities.Tag;
import com.mmasenheimer.makerthread.repositories.TagRepository;
import com.mmasenheimer.makerthread.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
