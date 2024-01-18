package com.example.auctionsystemapp.mappers;

import com.example.auctionsystemapp.data.models.Address;
import com.example.auctionsystemapp.data.models.User;
import com.example.auctionsystemapp.dto.RegisterRequest;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User user = new User();
        Address address = new Address();
        user.setUsername(registerRequest.getUsername());
        user.setContact(registerRequest.getContact());
        user.setAddress(address);
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        return user;
    }
}
