package com.rewardshub.service;


import com.rewardshub.config.SecurityConfig;
import com.rewardshub.dto.CreateUserDTO;
import com.rewardshub.dto.JwtTokenDTO;
import com.rewardshub.dto.LoginUserDTO;
import com.rewardshub.model.Business;
import com.rewardshub.model.ModelRole;
import com.rewardshub.model.User;
import com.rewardshub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    private BusinessService businessService;

    public void saveUser(CreateUserDTO createUserDto) {
        User newUser = User.builder()
                .email(createUserDto.email())
                .password(securityConfig.passwordEncoder().encode(createUserDto.password()))
                .roles(List.of(ModelRole.builder().name(createUserDto.role()).build()))
                .build();

        userRepository.save(newUser);
    }

    public JwtTokenDTO authenticateUser(LoginUserDTO loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        ModelUserDetailsImpl modelUserDetails = (ModelUserDetailsImpl) authentication.getPrincipal();
        return new JwtTokenDTO(jwtTokenService.generateToken(modelUserDetails));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user != null) {
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRoles(userDetails.getRoles());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}