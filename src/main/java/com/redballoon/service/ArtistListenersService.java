package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.ArtistListeners;


public interface ArtistListenersService {

    public ArtistListeners findArtistListenersByCountry(Artist artist, String country);
    public void save(ArtistListeners artistListeners);
}
