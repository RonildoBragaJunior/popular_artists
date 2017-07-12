package com.redballoon.service;


import com.redballoon.model.Artist;

import java.util.List;

public interface ArtistService {

    public Artist findByName(String name);
    public Artist findById(Long id);
    public List<Artist> findAll();
    public Artist saveArtist(Artist artist);
    public void clean();

}
