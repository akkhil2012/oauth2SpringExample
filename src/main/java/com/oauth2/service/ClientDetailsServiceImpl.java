package com.oauth2.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by akhilg on 5/30/2014.
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService{

    private String user_id;
    private String secret_key;

    Logger logg = Logger.getLogger("ClientDetailsServiceImpl.class");


    public ClientDetails loadClientByClientId(String clientId){

        logg.info("Inside Clients Details method........................");

        if (clientId.equals(user_id))
        {
            logg.info("Inside if clause in Clients Dteails.......................");
            List<String> authorizedGrantTypes = new ArrayList<String>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");

            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId(user_id);
            clientDetails.setClientSecret(secret_key);
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);

            return clientDetails;
        }
        else {
            logg.info("Inside else clause in cleints details");
            throw new NoSuchClientException("No client recognized with id: "
                    + clientId);
        }


    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }



}
