package com.productmanagment.productmanagment.DTOAssemblers.userAssemblerFactory;
import com.productmanagment.productmanagment.dtos.UserDTO;
import com.productmanagment.productmanagment.models.User;
import com.productmanagment.productmanagment.models.UserLogin;
import org.springframework.beans.BeanUtils;


public class UserAssemblerHibernate implements UserAssembler {

    @Override
    public User Dto2Pojo(UserDTO userDTO) {
        if(userDTO == null) return null;
        User result = new User();
        BeanUtils.copyProperties(userDTO, result);
        if(result.getUserId()!= null && result.getUserId() == 0){
            result.setUserId(null);
        }
        //Set UserLogin
        UserLogin userLogin = new UserLogin();
        userLogin.setUser(result);
        userLogin.setPassword(userDTO.getPassword());
        userLogin.setUsername(userDTO.getUsername());
        userLogin.setRol(userDTO.getUserRole());
        result.setUserLogin(userLogin);
        return result;
    }

    @Override
    public UserDTO pojo2Dto(User user) {
        if(user == null) return null;

        UserDTO result = new UserDTO();
        BeanUtils.copyProperties(user, result);
        if(result.getUserId() != null && result.getUserId() == 0){
            result.setUserId(null);
        }
        if(user.getUserLogin()!= null){
            result.setUsername(user.getUserLogin().getUsername());
            result.setUserRole(user.getUserLogin().getRol());
        }
        result.setPassword(null);
        return result;
    }

}
