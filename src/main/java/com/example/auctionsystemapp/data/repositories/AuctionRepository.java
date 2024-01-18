package com.example.auctionsystemapp.data.repositories;

import com.example.auctionsystemapp.data.models.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuctionRepository extends MongoRepository<Auction, String> {
}
