package com.miguel.mongo.services;

import com.miguel.mongo.dto.UserDTO;
import com.miguel.mongo.entities.User;
import com.miguel.mongo.repositories.UserRepository;
import com.miguel.mongo.services.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findBYId(String id) {

        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado !"));
    }

    public User fromDTO(UserDTO userDTO) {

        return new User(userDTO.getName(), userDTO.getEmail());
    }

    public User insert(User user) {

        return userRepository.insert(user);
    }

    public void deleteById(String id) {

        if(!userRepository.existsById(id)) throw new UserNotFoundException("Usuário não encontrado !");

        userRepository.deleteById(id);
    }

    private void updateData(User src, User dest) {
        dest.setName(src.getName());
        dest.setEmail(src.getEmail());
    }

    public void update(User user) {

        var obj = userRepository.findById(user.getId());

        if(obj.isEmpty()) throw new UserNotFoundException("Usuário não encontrado !");

        updateData(user, obj.get());

        userRepository.save(obj.get());

    }
}
