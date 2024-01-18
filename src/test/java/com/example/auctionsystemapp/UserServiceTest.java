package com.example.auctionsystemapp;

import com.example.auctionsystemapp.data.models.Address;
import com.example.auctionsystemapp.data.repositories.AuctionRepository;
import com.example.auctionsystemapp.data.repositories.UserRepository;
import com.example.auctionsystemapp.dto.RegisterRequest;
import com.example.auctionsystemapp.exceptions.InvalidDetailsException;
import com.example.auctionsystemapp.exceptions.UserExistException;
import com.example.auctionsystemapp.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuctionRepository auctionRepository;
    @AfterEach
    public void doThisThisAfterEachTest(){
        userRepository.deleteAll();
        auctionRepository.deleteAll();
    }

    @Test
    public void register_User_TryRegisteringSameUser_ThrowException(){
        RegisterRequest registerRequest = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("5 Agboola street");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setPostalCode("23452");
        registerRequest.setUsername("philip");
        registerRequest.setAddress(address);
        registerRequest.setContact("1424");
        registerRequest.setEmail("philipodey75@gmail.com");
        userService.register(registerRequest);
        assertThrows(UserExistException.class, ()-> userService.register(registerRequest));
    }

    @Test
    public void registerUser_Login_WithWrongPassword_ThrowException(){
        RegisterRequest registerRequest = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("5 Agboola street");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setPostalCode("23452");
        registerRequest.setUsername("philip");
        registerRequest.setAddress(address);
        registerRequest.setContact("1424");
        registerRequest.setPassword("password");
        registerRequest.setEmail("philipodey75@gmail.com");
        userService.register(registerRequest);
        assertThrows(InvalidDetailsException.class, ()-> userService.login("username12", "password"));
    }
    @Test
    public void registerUser_LoginWithRightDetails_AuctionGoods(){
        RegisterRequest registerRequest = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("5 Agboola street");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setPostalCode("23452");
        registerRequest.setUsername("philip");
        registerRequest.setAddress(address);
        registerRequest.setContact("1424");
        registerRequest.setPassword("password");
        registerRequest.setEmail("philipodey75@gmail.com");
        userService.register(registerRequest);
        userService.login("philip", "password");
        userService.addAuction("philip",1200.00, "1","4 days", 4000.00, "12.67", true);
    }
    @Test
    public void registerUser_LoginWithRightDetails_AuctionGoods_findGoodsAuctioned(){
        RegisterRequest registerRequest = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("5 Agboola street");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        address.setPostalCode("23452");
        registerRequest.setUsername("philip");
        registerRequest.setAddress(address);
        registerRequest.setContact("1424");
        registerRequest.setPassword("password");
        registerRequest.setEmail("philipodey75@gmail.com");
        userService.register(registerRequest);
        userService.login("philip", "password");
        userService.addAuction("philip",1200.00, "1","4 days", 4000.00, "12.67", true);
        assertEquals(1, userService.findAuctionBelongingTo("philip").size());
    }

}
