package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private String id;
    private String username;
    private Address address;
    private String contact;
    private String email;
    private String password;
    private UserType role;
    private boolean isLoggedIn;
}
