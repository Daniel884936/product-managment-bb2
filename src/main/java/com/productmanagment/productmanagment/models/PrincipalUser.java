package com.productmanagment.productmanagment.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

/**
 * This class is to handle user authentication whit sprint security
 * Note: this is not a model from database
 * @Author Erick Tejada Montero
 */


public class PrincipalUser implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser( String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * This method return principalUser with UserLogin
     */
    public static PrincipalUser build(UserLogin userLogin){
        Set<Rol> roles = new HashSet<>();
        roles.add(userLogin.getRol());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(rol -> authorities.add(new SimpleGrantedAuthority(rol.name())));
        return new PrincipalUser(userLogin.getUsername(), userLogin.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
