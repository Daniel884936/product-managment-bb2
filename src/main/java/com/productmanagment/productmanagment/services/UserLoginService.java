package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.UserLoginDTO;

public interface UserLoginService {

    public UserLoginDTO getLoginByCredentials(UserLoginDTO userLoginDTO);
}
