package com.dsm.spotemo.entity;

import com.dsm.spotemo.entity.value.Emotion;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    @Embedded
    private Emotion emotion;
    private Date createdAt;
}
