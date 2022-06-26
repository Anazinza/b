package com.dsm.spotemo.entity.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class DayPostInfo {
    private Date day;
    private int postId;
    private String postTitle;
//    @Embedded
    private Emotion postEmotion;
}
