package com.dsm.spotemo.entity.value;

import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"postId"})
public class DayPostInfo {
    private LocalDate day;
    private ObjectId postId;
    private String postTitle;
    private String postEmotion;
}
