package com.dsm.spotemo.entity.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Date;

@Embeddable
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
