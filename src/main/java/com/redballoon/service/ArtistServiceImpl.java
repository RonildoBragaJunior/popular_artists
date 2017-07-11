package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.ArtistListeners;
import com.redballoon.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("artistServiceImpl")
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist findArtistByName(String name) {
        return artistRepository.findByName(name);
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }
}
