package com.example.auctionsystemapp.services;

import com.example.auctionsystemapp.data.models.Auction;
import com.example.auctionsystemapp.data.repositories.UserRepository;
import com.example.auctionsystemapp.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public interface UserService {


    void register(RegisterRequest registerRequest);

    void login(String username, String password);

    void addAuction(String username,double hammerPrice, String lotNumber, String duration, double reservedPrice, String vat, boolean isActive);

    List<Auction> findAuctionBelongingTo(String username);
}

