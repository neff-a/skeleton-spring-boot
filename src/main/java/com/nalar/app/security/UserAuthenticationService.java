package com.nalar.app.security;
/*
    Copyright (c) 2019 Neftali Alarcón
*/

import com.nalar.app.dto.UserDTO;
import com.nalar.app.model.User;
import com.nalar.app.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

    @Autowired
    private UserService userService;

    public TokenDetail authenticate(final String email, final String password) {

        final User user = userService.findOneByEmailAndStatus(email, "ACTIVE");

        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(password)) {
            return null;
        }

        final String token = Jwts.builder().setSubject(email).claim("roles", "user")
            .setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();

        return new TokenDetail(token);
    }

    public void register(final UserDTO userInfo) {
        final User user = new User();
        user.setEmail(userInfo.email);
        user.setFirstName(userInfo.firstName);
        user.setLastName(userInfo.lastName);
        user.setLocale(userInfo.locale);
        user.setPassword(userInfo.password);
        userService.store(user);
    }
}
