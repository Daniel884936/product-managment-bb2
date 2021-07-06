package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.dtos.UserLoginDTO;
import com.productmanagment.productmanagment.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/token")
@RestController
@Validated
public class TokenController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping
    public ResponseEntity getTokenByCredentials(@RequestBody UserLoginDTO userLoginDTO){
        userLoginDTO = userLoginService.getLoginByCredentials(userLoginDTO);
        return ResponseEntity.ok(userLoginDTO);
    }
}
