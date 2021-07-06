package com.productmanagment.productmanagment.controllers;

import com.productmanagment.productmanagment.apiresponses.ApiResponse;
import com.productmanagment.productmanagment.dtos.UserDTO;
import com.productmanagment.productmanagment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll(){
        List<UserDTO> userDTOS = userService.getAll();
        return  ResponseEntity.ok(new ApiResponse<>(userDTOS));
    }

    @GetMapping("/{id}")
    public  ResponseEntity getById(@PathVariable("id") Long id){
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true));
    }

    @PostMapping
    public ResponseEntity Post(@RequestBody UserDTO userDTO){
        userDTO =  userService.add(userDTO);
        return  ResponseEntity.ok(new ApiResponse<>(userDTO));
    }
}