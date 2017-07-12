package com.redballoon.controller;

import com.redballoon.model.Listeners;
import com.redballoon.model.User;
import com.redballoon.service.ListenersServiceImpl;
import com.redballoon.service.LastfmService;
import com.redballoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private LastfmService lastfmService;
    @Autowired
    private ListenersServiceImpl listenersServiceImpl;


    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/consumeLastfmWebservice")
    public String consumeLastfmWebservice(@RequestParam("country") String country) {
        lastfmService.consumeLastfmWebservice(country);
        return "the list has been updated";
    }

    @ResponseBody
    @RequestMapping(value = "/loadWebserviceTable")
    public String loadWebserviceTable() {
        List<Listeners> artistList = listenersServiceImpl.listListenersByCountry("australia");
        String result = new String();

        result+="{\"data\": [";
        for(Listeners listeners : artistList) {
            result+="[\""+ listeners.getArtist().getId()+"\",";
            result+="\""+ listeners.getArtist().getName()+"\",";
            result+="\""+ listeners.getCountry()+"\",";
            result+="\""+ listeners.getListeners()+"\"],";
        }
        result = result.substring(0,result.length() - 1);
        result+="]}";

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/loadFavouriteTable")
    public String loadFavouriteTable() {

        return "{\"data\": [[\"1\",\"Ronildo\"],[\"2\",\"Metalica\"]]}";
    }

    @ResponseBody
    @RequestMapping(value = "/saveFavourite")
    public String saveFavourite(@RequestParam("id_list") String id_list) {

        return "the favourite has been inserted"+id_list;
    }


}
