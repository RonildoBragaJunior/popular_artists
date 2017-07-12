package com.redballoon.controller;

import com.redballoon.model.Favourite;
import com.redballoon.model.Listeners;
import com.redballoon.model.User;
import com.redballoon.service.*;
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
    private ListenersService listenersService;
    @Autowired
    private FavouriteService favouriteService;


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
        List<Listeners> artistList = listenersService.listListenersByCountry("australia");
        StringBuffer result = new StringBuffer();

        result.append("{\"data\": [");
        for(Listeners listeners : artistList) {
            result.append("[\""+ listeners.getArtist().getId()+"\",");
            result.append("\""+ listeners.getArtist().getName()+"\",");
            result.append("\""+ listeners.getCountry()+"\",");
            result.append("\""+ listeners.getListeners()+"\"],");
        }
        result.append("]}");
        return result.replace(result.length() - 3, result.length()-2, "").toString();
    }

    @ResponseBody
    @RequestMapping(value = "/loadFavouriteTable")
    public String loadFavouriteTable() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        List<Favourite> favouriteList = favouriteService.listByUser(user);

        StringBuffer result = new StringBuffer();
        result.append("{\"data\": [");
        for(Favourite favourite : favouriteList) {
            result.append("[\""+ favourite.getArtist().getId()+"\",");
            result.append("\""+ favourite.getArtist().getName()+"\",");
            result.append("\""+ favourite.getArtist().getUrl()+"\"],");
        }
        result.append("]}");
        return result.replace(result.length() - 3, result.length()-2, "").toString();
    }

    @ResponseBody
    @RequestMapping(value = "/saveFavourite")
    public String saveFavourite(@RequestParam("id_list") String id_list) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        favouriteService.save(auth.getName(), id_list.split(";"));

        return "the favourite has been inserted"+id_list;
    }


}
