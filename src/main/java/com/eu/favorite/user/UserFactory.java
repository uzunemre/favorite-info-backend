package com.eu.favorite.user;

import com.eu.favorite.user.dto.UserSignUpRequest;

class UserFactory {

    static User createUser(UserSignUpRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setPassword(request.getPassword());
        return user;
    }

}
