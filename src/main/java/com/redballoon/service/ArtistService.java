package com.redballoon.service;


import com.redballoon.model.Artist;

public interface ArtistService {

    public Artist findByName(String name);
    public Artist saveArtist(Artist artist);
    public Artist findById(Long id);

}
