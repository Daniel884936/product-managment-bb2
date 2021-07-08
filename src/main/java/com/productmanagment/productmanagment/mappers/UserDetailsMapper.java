package com.productmanagment.productmanagment.mappers;


import com.productmanagment.productmanagment.models.Rol;
import com.productmanagment.productmanagment.models.UserLogin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashSet;
import java.util.Set;


public class UserDetailsMapper {

    public static UserDetails build(UserLogin userLogin){
        return  new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(), getAuthorities(userLogin));
    }

    private static Set<? extends GrantedAuthority> getAuthorities(UserLogin retrievedUser){
        Set<Rol> roles = new HashSet<>();
        roles.add(retrievedUser.getRol());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(rol -> authorities.add(new SimpleGrantedAuthority(rol.name())));
        return authorities;
    }
}
