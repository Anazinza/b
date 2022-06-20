package com.dsm.spotemo.dto.request;

import com.dsm.spotemo.entity.value.Emotion;
import lombok.Getter;

@Getter
public class PostCreateRequest {
    private String title;
    private String content;
    private String emotion;
}
