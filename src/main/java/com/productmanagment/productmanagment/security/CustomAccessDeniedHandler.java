package com.productmanagment.productmanagment.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final static Logger logger = LoggerFactory.getLogger(AccessDeniedHandler.class);
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        logger.error("failed in handle method"+ e.getMessage()+ " "+ e.getLocalizedMessage());
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "FORBIDDEN");
    }
}
