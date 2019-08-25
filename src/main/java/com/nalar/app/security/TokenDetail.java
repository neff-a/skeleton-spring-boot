package com.nalar.app.security;

/*
    Copyright (c) 2019 Neftali Alarcón
*/

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDetail {

    private String token;

    private Date timestamp;

    public TokenDetail(final String token) {
        this.token = token;
        timestamp = new Date();
    }

}
