package com.social.controller;

import com.oauth2.service.FacebookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 6/1/14
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */

@RequestMapping(value = "/social/facebook")
@Controller
public class FacebookController {

    //private static final String SCOPE = "email,offline_access,user_about_me,user_birthday,read_friendlists,publish_actions,user_status";
    private static final String SCOPE = "user_status";
    private static final String REDIRECT_URI = "http://sampleapp.com:8080/oauth2SpringExample-1.0-SNAPSHOT/social/facebook/FacebookCallback";
    private static final String CLIENT_ID = "667686176613908";
    private static final String APP_SECRET = "667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k";
    private static final String DIALOG_OAUTH = "https://www.facebook.com/dialog/oauth";
    private static final String ACCESS_TOKEN = "https://graph.facebook.com/oauth/access_token";

  //  public static final String POST_MSG = "https://graph.facebook.com/122788341354";

    Logger logg = Logger.getLogger("FacebookController.class");


   @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public void signin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        logg.info("Inside method ----------->>> signIn");

        String post = request.getParameter("postText");

        try {
            //if already have a valid access token, no need to redirect, just login
            String redirectURL = DIALOG_OAUTH+"?"
                    +"client_id="+CLIENT_ID+
                    "&redirect_uri="+REDIRECT_URI+
                    "&scope="+SCOPE;

            logg.info("Response Object inside method signin is--------------->>>>"+redirectURL);

            response.sendRedirect(redirectURL);

          /*  response.sendRedirect(DIALOG_OAUTH+"?"
                    +"client_id="+CLIENT_ID+
                    "&redirect_uri="+REDIRECT_URI+
                            "&scope="+SCOPE);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*    @RequestMapping(value = "/deleteUser/{userID}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("userID") Integer userID ,  ModelMap modelMap)*/

/*    @RequestMapping(value = "/signin/{search}", method = RequestMethod.POST)
    public void signin( @PathVariable("search") Integer search) {
        logg.info("Text to search is=====" + search);

        logg.info("Inside method ----------->>> signInNEW");

    //    String post = request.getParameter("postText");
        // return empData.get(empId);


    logg.info("search Text is --------------------->>>>"+search);

}*/



    @RequestMapping(value = "/FacebookCallback", params = "code", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView  accessCode(@RequestParam("code") String code,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        FacebookService facebookService = new FacebookService();

        try {
            response.setContentType("text/html");
          /* String responseString = IntegrationBase.readURLGET(ACCESS_TOKEN,
                    new String []{"client_id","redirect_uri","code", "client_secret"},
                    new String[]{CLIENT_ID,REDIRECT_URI,code,APP_SECRET});
           response.getWriter().write(responseString);*
            response.flushBuffer();*/

            logg.info("Inside Post Message to FB method......");



            facebookService.postMessage("?????????????????????????????");

            logg.info("Inside Post Message to FB method......After Posting to FB....");



            modelAndView.setViewName("PostMessage");

            modelAndView.addObject("response", "This is welcome page!");

            logg.info("response objecct is ------------------->>>"+response.getStatus());

         //   modelAndView.setViewName("PostToFB");

        } catch (Exception e) {

            e.printStackTrace();

        }
        return  modelAndView;
    }



    @RequestMapping(value = "/FacebookCallback", params = "error_reason", method = RequestMethod.GET)
    @ResponseBody
    public void error(@RequestParam("error_reason") String errorReason,
                      @RequestParam("error") String error,
                      @RequestParam("error_description") String description,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            logg.info("Inside error block in FB Controller......");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
            logg.info("Inside error block in FB Controller with response......"+response);
        } catch (Exception e) {
            logg.info("Inside error catch block in FB Controller......");

            e.printStackTrace();
        }
    }





}
