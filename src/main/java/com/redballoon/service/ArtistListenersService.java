package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.ArtistListeners;

import java.util.List;


public interface ArtistListenersService {

    public ArtistListeners findArtistListenersByCountry(Artist artist, String country);
    public List<ArtistListeners> listArtistListenersByCountry(String country);
    public void save(ArtistListeners artistListeners);
}
