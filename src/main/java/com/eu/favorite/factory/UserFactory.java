package com.eu.favorite.factory;

import com.eu.favorite.model.User;
import com.eu.favorite.dto.UserSignUpRequest;

public class UserFactory {

    public static User createUser(UserSignUpRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setPassword(request.getPassword());
        return user;
    }

}
