package com.oauth2.service;

import facebook4j.*;
import facebook4j.api.PostMethods;
import facebook4j.conf.ConfigurationContext;
import facebook4j.internal.logging.Logger;

/**
 * Created by akhilg on 6/2/2014.
 */
public class FacebookService {

  //  final Facebook facebook = new FacebookFactory().getInstance();
    String message="";

    Logger logg = Logger.getLogger(FacebookService.class);

  PostUpdate postUpdate = new PostUpdate("");


    public void postMessage(String msg){

        logg.info("Inside postMessgae method in FaceBookService....");
    //    final Facebook facebook = new FacebookFactory().getInstance();
      //  facebook.setOAuthAppId();
        try {
            new FacebookFactory().getInstance().postStatusMessage("test status");
        }catch (Exception e) {

        }
        PrivacyParameter privacy = new PrivacyBuilder().setValue(PrivacyType.ALL_FRIENDS).build();


        postUpdate.setPublished(Boolean.TRUE);


        postUpdate.setPrivacy(privacy);

        postUpdate.setMessage(msg);

        postUpdate.getPublished();


      //  PostMethods postMethods =  new FacebookFactory().getInstance();


/*
        try {

            final String status = facebook.postStatusMessage("test status messsage");

            postUpdate.
        }catch (FacebookException  e)
        {

        }
*/


   //     postUpdate.getMessage();

        logg.info("Message retreived is .............."+postUpdate.getMessage());



    }

}
