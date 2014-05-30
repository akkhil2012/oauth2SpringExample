package com.oauth2.service;

import com.oauth2.OauthAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhilg on 5/30/2014.
 */
public class CustomUserAuthenticationProvider implements AuthenticationProvider{
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

            OauthAuthenticationToken auth = new OauthAuthenticationToken(authentication.getPrincipal(),
                    authentication.getCredentials(), grantedAuthorities);


            return auth;


    }


    public boolean supports(Class<?> arg0){
        return  true;
    }




}
