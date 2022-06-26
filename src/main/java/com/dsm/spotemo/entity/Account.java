package com.dsm.spotemo.entity;


import com.dsm.spotemo.entity.value.WriteDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Document
public class Account {
    @Id
    private String email;
    private String nickname;
    private String password;
    private boolean isLive = true;
    private WriteDate writeDate;
}