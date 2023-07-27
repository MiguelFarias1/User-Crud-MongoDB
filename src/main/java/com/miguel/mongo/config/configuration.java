package com.miguel.mongo.config;

import com.miguel.mongo.entities.Post;
import com.miguel.mongo.entities.User;
import com.miguel.mongo.repositories.PostRepository;
import com.miguel.mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class configuration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        var user1 = new User("Maria", "maria@teste.com");
        var user2 = new User("Miguel", "miguel@teste.com");
        var user3 = new User("Gabriel", "gabriel@teste.com");

        userRepository.saveAll(List.of(user1,user2,user3));

        Post post1 = new Post(null, LocalDateTime.now(), "Teste", "Bom dia !", user1);

        postRepository.save(post1);
    }
}
