package com.nalar.app.configuration;

/*
    Copyright (c) 2019 Neftali Alarcón
*/

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilterConf extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authorizationHeader = getAuthorizationHeader(request);

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            if (authorizationHeader != null && !authorizationHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing Authorization header");
            }
            try {

                final String token = getToken(authorizationHeader);
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token)
                    .getBody();
                request.setAttribute("claims", claims);

            } catch (Exception e) {

                throw new ServletException("Invalid token");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getToken(String authorizationHeader) {
        return authorizationHeader.substring(7);
    }

    private String getAuthorizationHeader(HttpServletRequest request) {
        return request.getHeader("authorization");
    }
}
