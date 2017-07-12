package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.Listeners;

import java.util.List;


public interface ListenersService {

    public Listeners findListenersByCountry(Artist artist, String country);
    public List<Listeners> listListenersByCountry(String country);
    public void save(Listeners listeners);
}
