package com.miguel.mongo.repositories;

import com.miguel.mongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
