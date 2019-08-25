package com.nalar.app.controller;

import com.nalar.app.model.User;
import com.nalar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Copyright (c) 2019 Neftali Alarcón
*/
@RequestMapping("/api/users")
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{uuid}")
    public User findOneByUuidUser(@PathVariable("uuid") final String uuid) {
        return userService.findOneByUuid(uuid);
    }
}
