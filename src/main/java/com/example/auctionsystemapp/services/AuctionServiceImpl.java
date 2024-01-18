package com.example.auctionsystemapp.services;

import com.example.auctionsystemapp.data.models.Auction;
import com.example.auctionsystemapp.data.repositories.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService{
    @Autowired
    private AuctionRepository auctionRepository;
    @Override
    public void addAuction(String sellerId, double hammerPrice, String lotNumber, String duration, double reservedPrice, String vat, boolean isActive) {
        Auction auction = new Auction();
        auction.setSellerId(sellerId);
        auction.setDuration(duration);
        auction.setActive(isActive);
        auction.setReservedPrice(reservedPrice);
        auction.setHammerPrice(hammerPrice);
        auctionRepository.save(auction);
    }

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }
}