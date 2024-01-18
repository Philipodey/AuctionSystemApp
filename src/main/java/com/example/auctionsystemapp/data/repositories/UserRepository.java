package com.example.auctionsystemapp.data.repositories;

import com.example.auctionsystemapp.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
