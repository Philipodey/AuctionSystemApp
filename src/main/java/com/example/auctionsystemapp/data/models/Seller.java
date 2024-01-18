package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Seller {
    private String username;
    private String password;
}
