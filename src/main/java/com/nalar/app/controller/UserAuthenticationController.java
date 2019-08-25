package com.nalar.app.controller;

/*
    Copyright (c) 2019 Neftali Alarcón
*/

import com.nalar.app.dto.UserDTO;
import com.nalar.app.security.TokenDetail;
import com.nalar.app.security.UserAuthenticationService;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthenticationController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @PostMapping("/register")
    public void registerUser(@RequestBody final UserDTO user) {
        userAuthenticationService.register(user);
    }

    @PostMapping("/login")
    public TokenDetail authenticateUser(@RequestBody final UserDTO user) throws ServletException {
        validateUserRequest(user);
        final TokenDetail token = userAuthenticationService
            .authenticate(user.email, user.password);
        if (token == null) {
            throw new ServletException("Invalid user");
        }
        return token;
    }

    private void validateUserRequest(@RequestBody UserDTO user)
        throws ServletException {
        if (user.email == null || user.password == null) {
            throw new ServletException("Invalid parameters");
        }
    }

}
