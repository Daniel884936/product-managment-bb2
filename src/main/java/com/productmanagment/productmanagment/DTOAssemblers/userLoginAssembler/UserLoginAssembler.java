package com.productmanagment.productmanagment.DTOAssemblers.userLoginAssembler;

import com.productmanagment.productmanagment.dtos.UserLoginDTO;
import com.productmanagment.productmanagment.models.UserLogin;

public interface UserLoginAssembler {
    public UserLogin dto2Pojo(UserLoginDTO userLoginDTO);
    public  UserLoginDTO pojo2Dto(UserLogin userLogin);
}
