package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.Listeners;

import java.util.List;


public interface ListenersService {

    public Listeners findByCountry(Artist artist, String country);
    public List<Listeners> findByCountry(String country);
    public List<Listeners> findAll();
    public void save(Listeners listeners);
}
