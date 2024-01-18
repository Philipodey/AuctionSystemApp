package com.example.auctionsystemapp.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document
public class Payment {
    private String creditCardNumber;
    private Date expiryDate;
    private BigDecimal amount;
    private String userId;
}
