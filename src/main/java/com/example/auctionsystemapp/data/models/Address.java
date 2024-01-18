package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    private String homeAddress;
    private String country;
    private String state;
    private String postalCode;
}

