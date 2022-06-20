package com.dsm.spotemo.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EmotionListResponse {
    private List<String> emotions;
}
