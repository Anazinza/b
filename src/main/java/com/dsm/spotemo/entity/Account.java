package com.dsm.spotemo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Entity
public class Account {
    @Id
    private String email;
    private String nickname;
    private String password;
    private int isLive = 1;
}