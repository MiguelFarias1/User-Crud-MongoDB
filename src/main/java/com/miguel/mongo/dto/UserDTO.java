package com.miguel.mongo.dto;

import com.miguel.mongo.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
public class UserDTO implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}