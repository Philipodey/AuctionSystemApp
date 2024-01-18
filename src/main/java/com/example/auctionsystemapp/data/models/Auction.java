package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Auction {
    @Id
    private String auctionId;
    private LocalDateTime auctionStartingDate = LocalDateTime.now();
    private double reservedPrice;
    private String duration;
    private String vat;
    private String sellerId;
    private double hammerPrice;
    private boolean isActive;
}
