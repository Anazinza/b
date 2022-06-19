package com.dsm.spotemo.entity.value;

import lombok.Getter;

@Getter
public enum Nickname {
    a ("활기찬 강아지"),
    b ("행복한 오징어"),
    c ("행복한 감자"),
    d ("임연상"),
    e ("책읽는 망고"),
    f ("깨끗한 두루미"),
    g ("날고있는 양말");


    private String nickname;

    Nickname(String nickname) {
        this.nickname = nickname;
    }
}
