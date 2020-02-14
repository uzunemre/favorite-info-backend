package com.eu.favorite.user;

import com.eu.favorite.shared.CurrentUser;
import com.eu.favorite.user.dto.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/1.0/login")
    UserResponse login(@CurrentUser User loggedInUser) {
        return new UserResponse(loggedInUser);
    }

}
