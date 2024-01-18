package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Buyer {
    private String username;
    private String password;
}
