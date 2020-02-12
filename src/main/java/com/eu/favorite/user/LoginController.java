package com.eu.favorite.user;

import com.eu.favorite.shared.CurrentUser;
import com.eu.favorite.user.request.SignUpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	SignUpRequest login(@CurrentUser User loggedInUser) {
		return new SignUpRequest(loggedInUser);
	}
	
}
