package com.rewardshub.controller;


import com.rewardshub.dto.CreateUserDTO;
import com.rewardshub.dto.JwtTokenDTO;
import com.rewardshub.dto.LoginUserDTO;
import com.rewardshub.model.Business;
import com.rewardshub.model.User;
import com.rewardshub.service.BusinessService;
import com.rewardshub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BusinessService businessService;

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDTO> loginUser(@RequestBody LoginUserDTO loginUserDto) {
        JwtTokenDTO token = userService.authenticateUser(loginUserDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody CreateUserDTO createUserDto) {
        userService.saveUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsersByBusiness(Long businessId) {
        Business business = this.businessService.getBusinessById(businessId);
        return userService.getAllUsers();

    }
}