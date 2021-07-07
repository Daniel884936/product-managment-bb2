package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.UserLoginDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserLoginService extends UserDetailsService {

    public UserLoginDTO getLoginByCredentials(UserLoginDTO userLoginDTO);
}
