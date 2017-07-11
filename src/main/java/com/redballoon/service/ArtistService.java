package com.redballoon.service;


import com.redballoon.model.Artist;

public interface ArtistService {

    public Artist findArtistByName(String name);
    public void saveArtist(Artist artist);
}
