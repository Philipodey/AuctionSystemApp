package com.example.auctionsystemapp.services;

import com.example.auctionsystemapp.data.models.Auction;
import com.example.auctionsystemapp.data.models.User;
import com.example.auctionsystemapp.data.repositories.UserRepository;
import com.example.auctionsystemapp.dto.RegisterRequest;
import com.example.auctionsystemapp.exceptions.InvalidDetailsException;
import com.example.auctionsystemapp.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.auctionsystemapp.mappers.Mapper.map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuctionService auctionService;

    @Override
    public void register(RegisterRequest registerRequest) {
        if(userExist(registerRequest.getUsername())) throw new UserExistException(registerRequest.getUsername() + " already exist!!!!");
        User user = map(registerRequest);
        userRepository.save(user);
    }

    @Override
    public void login(String username, String password) {
        User userFound = userRepository.findByUsername(username);
        if (!userExist(username)) throw new InvalidDetailsException();
        if (!userFound.getPassword().equals(password)) throw new InvalidDetailsException();
        userFound.setLoggedIn(true);
        userRepository.save(userFound);
    }

    @Override
    public void addAuction(String username,double hammerPrice, String lotNumber, String duration, double reservedPrice, String vat, boolean isActive) {
        User findSeller = userRepository.findByUsername(username);

    }

    @Override
    public List<Auction> findAuctionBelongingTo(String username) {
        User findUser = userRepository.findByUsername(username);
        List<Auction> auctions = new ArrayList<>();
        for (Auction auction : auctionService.findAll()){
            if (auction.getAuctionId().equals(findUser.getId())) auctions.add(auction);
        }
        return auctions;
    }


    private boolean userExist(String name) {
        User findUser = userRepository.findByUsername(name);
        return findUser != null;
    }
}
