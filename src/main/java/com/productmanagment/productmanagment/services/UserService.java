package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.dtos.UserDTO;
import java.util.List;

public interface UserService {

    public UserDTO add(UserDTO userDTO);
    public void delete(Long id);
    public UserDTO getById(Long id);
    public List<UserDTO> getAll();

}
