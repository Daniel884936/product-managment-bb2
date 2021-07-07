package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory.HibernateDTOAssemblerFactory;
import com.productmanagment.productmanagment.dtos.UserLoginDTO;
import com.productmanagment.productmanagment.exception.NotFoundException;
import com.productmanagment.productmanagment.mappers.UserDetailsMapper;
import com.productmanagment.productmanagment.models.UserLogin;
import com.productmanagment.productmanagment.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserLoginDTO getLoginByCredentials(UserLoginDTO userLoginDTO) {
        UserLogin userLogin = userLoginRepository.getLoginByCredentials(userLoginDTO.getUsername(),
                userLoginDTO.getPassword());
        if(userLogin == null)
            throw new NotFoundException("Invalid email or password");
        return HibernateDTOAssemblerFactory.HIBERNATE.getUserLoginAssembler().pojo2Dto(userLogin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserLogin userFromDb = userLoginRepository.getByUserName(username);

        if(userFromDb == null){
            throw new NotFoundException("Invalid email or password");
        }
        return UserDetailsMapper.build(userFromDb);
    }
}
