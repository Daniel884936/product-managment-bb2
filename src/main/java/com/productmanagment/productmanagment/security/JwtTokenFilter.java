package com.productmanagment.productmanagment.security;

import com.productmanagment.productmanagment.services.UserLoginService;
import com.productmanagment.productmanagment.utils.TokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.productmanagment.productmanagment.utils.ApiConstants.HEADER_AUTHORIZATION_KEY;
import static com.productmanagment.productmanagment.utils.ApiConstants.TOKEN_BEARER_PREFIX;

public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    UserLoginService userLoginService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(req);
            if(token != null && TokenProvider.validateToken(token)){
                String username = TokenProvider.getUsername(token);
                UserDetails userDetails = userLoginService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                //UsernamePasswordAuthenticationToken auth = TokenProvider.getAuthentication(token, userDetails);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e){
            logger.error("fail doFilter method" + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader(HEADER_AUTHORIZATION_KEY);
        if(header != null && header.startsWith(TOKEN_BEARER_PREFIX))
            return header.replace(TOKEN_BEARER_PREFIX, "");
        return null;
    }
}
