package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.apiresponses.ApiResponse;
import com.productmanagment.productmanagment.dtos.UserLoginDTO;
import com.productmanagment.productmanagment.services.UserLoginService;
import com.productmanagment.productmanagment.utils.ApiToken;
import com.productmanagment.productmanagment.utils.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/token")
@RestController
@Validated
@CrossOrigin
public class TokenController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity getTokenByCredentials(@RequestBody UserLoginDTO userLoginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(),userLoginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TokenProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        ApiToken apiToken = new ApiToken();
        apiToken.setToken(jwt);
        apiToken.setExpirationDate(TokenProvider.getTokenExpiration());
        apiToken.setUserName(userDetails.getUsername());
        return ResponseEntity.ok(new ApiResponse<>(apiToken));
    }
}
