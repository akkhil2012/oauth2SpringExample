package com.social.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    private static final String SCOPE = "email,offline_access,user_about_me,user_likes";
    private static final String REDIRECT_URI = "http://49.206.44.37:8080/oauth2SpringExample-1.0-SNAPSHOT/FacebookCallback.jsp";
    private static final String CLIENT_ID = "667686176613908";
    private static final String APP_SECRET = "667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k";
    private static final String DIALOG_OAUTH = "https://www.facebook.com/dialog/oauth";
    private static final String ACCESS_TOKEN = "https://graph.facebook.com/oauth/access_token";

    Logger logg = Logger.getLogger("FacebookController.class");


    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public void signin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        logg.info("Inside method ----------->>> signIn");
        try {
            //TODO: if already have a valid access token, no need to redirect, just login
            response.sendRedirect(DIALOG_OAUTH+"?"
                    +"client_id="+CLIENT_ID+
                    "&redirect_uri="+REDIRECT_URI+
                            "&scope="+SCOPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/callback", params = "code", method = RequestMethod.GET)
    @ResponseBody
    public /*ModelAndView*/ void accessCode(@RequestParam("code") String code,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();

        try {
            response.setContentType("text/html");
           /* String responseString = IntegrationBase.readURLGET(ACCESS_TOKEN,
                    new String []{"client_id","redirect_uri","code", "client_secret"},
                    new String[]{CLIENT_ID,REDIRECT_URI,code,APP_SECRET});
           response.getWriter().write(responseString);
            response.flushBuffer();

            modelAndView.addObject("response", "This is welcome page!");

            logg.info("response objecct is ------------------->>>"+response);

            modelAndView.setViewName("OauthView");
*/


        } catch (Exception e) {
            e.printStackTrace();
        }
     //   return  modelAndView;
    }

    @RequestMapping(value = "/FacebookCallback", params = "error_reason", method = RequestMethod.GET)
    @ResponseBody
    public void error(@RequestParam("error_reason") String errorReason,
                      @RequestParam("error") String error,
                      @RequestParam("error_description") String description,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
