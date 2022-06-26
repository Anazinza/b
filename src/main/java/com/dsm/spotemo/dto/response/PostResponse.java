package com.dsm.spotemo.dto.response;

import com.dsm.spotemo.entity.value.Emotion;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PostResponse {
    private String id;
    private String title;
    private String content;
    private Emotion emotion;
    private LocalDate date;
}
