package com.oauth2;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by akhilg on 5/30/2014.
 */
public class OauthAuthenticationToken extends AbstractAuthenticationToken {

    private Object credentials;
    private Object principal;

    public OauthAuthenticationToken(Object principal, Object credentials,
                                      Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return this.credentials;
    }


    public Object getPrincipal(){
        return  this.principal;
    }


}
