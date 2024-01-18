package com.example.auctionsystemapp.exceptions;

public class InvalidDetailsException extends AuctionSystemException{
    public InvalidDetailsException() {
        super("Login Details is invalid!!!!");
    }
}
