package com.eu.favorite.controller;

import com.eu.favorite.model.User;
import com.eu.favorite.shared.CurrentUser;
import com.eu.favorite.dto.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/1.0/login")
    UserResponse login(@CurrentUser User loggedInUser) {
        return new UserResponse(loggedInUser);
    }

}
