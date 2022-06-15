package com.dsm.bamboo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Account {
    @Id
    private String email;
    private String password;
    private Boolean isLive;
}
