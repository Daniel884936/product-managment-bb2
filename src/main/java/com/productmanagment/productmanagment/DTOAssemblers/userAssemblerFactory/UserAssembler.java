package com.productmanagment.productmanagment.DTOAssemblers.userAssemblerFactory;
import com.productmanagment.productmanagment.dtos.UserDTO;
import com.productmanagment.productmanagment.models.User;

public interface UserAssembler  {
    public User Dto2Pojo(UserDTO userDTO);
    public UserDTO pojo2Dto(User user);
}
