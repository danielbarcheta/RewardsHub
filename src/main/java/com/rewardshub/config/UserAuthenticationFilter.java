package com.rewardshub.config;

import com.rewardshub.model.User;
import com.rewardshub.repository.UserRepository;
import com.rewardshub.service.JwtTokenService;
import com.rewardshub.service.ModelUserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (verificaEndpointsPublicos(request)) {
            String token = recuperaToken(request);
            if (token != null) {
                String subject = jwtTokenService.pegarToken(token);
                User modelUser = userRepository.findByEmail(subject).get();
                ModelUserDetailsImpl modelUserDetails = new ModelUserDetailsImpl(modelUser);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                                modelUserDetails.getUsername(),
                                null,
                                modelUserDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new RuntimeException("Token inexistente!");
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean verificaEndpointsPublicos(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return !Arrays.asList("/api/users/login", "/api/users").contains(requestURI);
    }

    private String recuperaToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

}