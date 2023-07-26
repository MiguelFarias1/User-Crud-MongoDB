package com.miguel.mongo.controllers;

import com.miguel.mongo.dto.UserDTO;
import com.miguel.mongo.entities.User;
import com.miguel.mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        var list = userService.findAll().stream().map(UserDTO::new).toList();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        var user = userService.findBYId(id);

        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {

        var user = userService.fromDTO(userDTO);

        userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(userDTO.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
