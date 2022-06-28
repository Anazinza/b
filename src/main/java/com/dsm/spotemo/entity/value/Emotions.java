package com.dsm.spotemo.entity.value;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
public class Emotions {
    private Set<String> emotions = new HashSet<>();

    public void addEmotion(String emotion) {
        emotions.add(emotion);
    }
}
