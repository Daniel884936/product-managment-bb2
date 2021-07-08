package com.productmanagment.productmanagment.services;
import com.productmanagment.productmanagment.exception.NotFoundException;
import com.productmanagment.productmanagment.models.PrincipalUser;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserLogin userFromDb = userLoginRepository.getByUserName(username);

        if(userFromDb == null){
            throw new NotFoundException("Invalid email or password");
        }
        return PrincipalUser.build(userFromDb);
    }
}
