package com.miguel.mongo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private LocalDateTime date;
    private String title;
    private String body;
    private User author;
}