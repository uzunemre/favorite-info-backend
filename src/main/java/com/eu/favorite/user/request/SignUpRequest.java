package com.eu.favorite.user.request;

import com.eu.favorite.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequest {

    private long id;

    private String username;

    private String name;

    private String surname;

    private String image;

    public SignUpRequest(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
    }

}
