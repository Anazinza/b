package com.dsm.spotemo.entity.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class DayPostInfo {
    private LocalDate day;
    private ObjectId postId;
    private String postTitle;
//    @Embedded
    private Emotion postEmotion;
}
