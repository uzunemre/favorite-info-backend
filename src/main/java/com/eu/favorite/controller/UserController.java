package com.eu.favorite.controller;

import javax.validation.Valid;

import com.eu.favorite.factory.UserFactory;
import com.eu.favorite.model.User;
import com.eu.favorite.shared.GenericResponse;
import com.eu.favorite.dto.UserSignUpRequest;
import com.eu.favorite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserSignUpRequest request) {
        User user = userService.save(UserFactory.createUser(request));
        return ResponseEntity.ok(new GenericResponse("User saved"));
    }
}
