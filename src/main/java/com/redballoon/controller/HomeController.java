package com.redballoon.controller;

import com.redballoon.model.Artist;
import com.redballoon.model.User;
import com.redballoon.service.LastfmService;
import com.redballoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private LastfmService lastfmService;


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
    @RequestMapping(value = "/lastfmapi/listArtistsByCountry")
    public ArtistsAjaxResponseBody listArtistsByCountry(@RequestBody SearchCriteria search) {

        ArtistsAjaxResponseBody result = new ArtistsAjaxResponseBody();

        List<Artist> artistList = lastfmService.listArtistByCountry(search.getCountry());

        if (artistList.size() > 0) {
            result.setCode("200");
            result.setMsg("");
            result.setResult(artistList);
        } else {
            result.setCode("204");
            result.setMsg("No artists in this country!");
        }

        return result;
    }
}
