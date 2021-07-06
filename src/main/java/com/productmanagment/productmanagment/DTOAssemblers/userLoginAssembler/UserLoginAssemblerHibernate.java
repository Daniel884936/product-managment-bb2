package com.productmanagment.productmanagment.DTOAssemblers.userLoginAssembler;

import com.productmanagment.productmanagment.dtos.UserLoginDTO;
import com.productmanagment.productmanagment.models.UserLogin;
import org.springframework.beans.BeanUtils;

public class UserLoginAssemblerHibernate implements UserLoginAssembler {

    @Override
    public UserLogin dto2Pojo(UserLoginDTO userLoginDTO) {
        if(userLoginDTO == null) return null;

        UserLogin result = new UserLogin();
        BeanUtils.copyProperties(userLoginDTO, result);
        if(result.getUserLoginId() != null && result.getUserLoginId() == 0)
            result.setUserLoginId(null);
        return result;
    }

    @Override
    public UserLoginDTO pojo2Dto(UserLogin userLogin) {
        if(userLogin == null) return null;

        UserLoginDTO  result = new UserLoginDTO();
        BeanUtils.copyProperties(userLogin,result );
        if(result.getUserLoginId()!= null && result.getUserLoginId() == 0)
            result.setUserLoginId(null);
        result.setPassword(null);
        return result;
    }
}
