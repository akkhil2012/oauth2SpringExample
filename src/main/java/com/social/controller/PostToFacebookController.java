package com.social.controller;

import com.oauth2.service.FacebookService;
import facebook4j.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by akhilg on 6/2/2014.
 */

@RequestMapping(value = "/facebook/post")
@Controller
public class PostToFacebookController {

    Logger logg = Logger.getLogger(PostToFacebookController.class);


    @RequestMapping(value = "/FacebookCallback", params = "code", method = RequestMethod.GET)
  //  @RequestMapping(value = "/{postText}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView postToFB(@RequestParam("code") String code,
                                 @RequestParam("postText") String postText,
                                 HttpServletRequest request, HttpServletResponse response){

        logg.info("Inside Post Message to FB method......");

        FacebookService facebookService = new FacebookService();

        facebookService.postMessage("??????????????????????????????????????????????????????????????????");

        logg.info("Inside Post Message to FB method......After Posting to FB....");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("PostMessage");

        return  modelAndView;

    }
}
