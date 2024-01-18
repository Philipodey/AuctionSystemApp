package com.example.auctionsystemapp.dto;

import com.example.auctionsystemapp.data.models.Address;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private Address address;
    private String contact;
    private String email;
    private String password;
}
