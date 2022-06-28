package com.dsm.spotemo.entity;

import com.dsm.spotemo.entity.value.Emotion;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document
public class Post {
    @Id
    private ObjectId id;

    private String title;
    private String content;
    private Emotion emotion;

    private int year; // date one value ?
    private int month;
    private LocalDate day;

    private boolean live=true;

    @DBRef(lazy = true)
    private Account account;

    public void postDelete() {
        this.live = false;
    }
}
