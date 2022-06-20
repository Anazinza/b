package com.dsm.spotemo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmotionController {
    private final EmotionService service;

    public void emotionList() {

    }
}
