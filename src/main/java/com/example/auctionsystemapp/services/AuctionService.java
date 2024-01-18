package com.example.auctionsystemapp.services;

import com.example.auctionsystemapp.data.models.Auction;

import java.util.List;

public interface AuctionService {
   void addAuction(String sellerId, double hammerPrice, String lotNumber, String duration, double reservedPrice, String vat, boolean isActive);
   List<Auction> findAll();
}
