package com.example.postcoreapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotNull
    @Column(name = "clientId")
    private String clientId;
    @NotNull
    @Column(name = "postRecipientId")
    private String postRecipientId;
    @Column(name ="postItem")
    private String postItem;
    @Column(name = "status")
    private String status;
}
