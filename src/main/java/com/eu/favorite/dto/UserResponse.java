package com.eu.favorite.dto;

import com.eu.favorite.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private long id;

    private String username;

    private String name;

    private String surname;

    public UserResponse(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
    }

}
