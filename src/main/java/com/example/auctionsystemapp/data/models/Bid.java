package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Bid {
    @Id
    private String bid;
    private String auctionId;
    private String BuyerId;
    private BigDecimal bidPrice = BigDecimal.ZERO;
    private BigDecimal currentBidPrice = BigDecimal.ZERO;
    private LocalDateTime biddingDate;

}
