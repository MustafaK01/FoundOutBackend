package com.mustafak01.foundoutbackendrestaurants.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenProviderJwt tokenProviderJwt;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //Extract the token from request
            String tokenJwt = extractFromReq(request);
            //Validate the token
            if (StringUtils.hasText(tokenJwt) && tokenProviderJwt.validateToken(tokenJwt)){
                //Parse the token and get email from it
                String userName = tokenProviderJwt.getUserNameFromJwt(tokenJwt);
                //find the username from userService with userRepository
                UserDetails user = userService.loadUserByUsername(userName);
                //if not null, authenticate it
                if(user!=null){
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            };
        }catch (Exception e ){
            return;
        }
        filterChain.doFilter(request,response);
    }

    //Get the request and extract the token
    private String extractFromReq(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")){
            return bearer.substring("Bearer".length()+1);
        };
        return null;
    }
}
