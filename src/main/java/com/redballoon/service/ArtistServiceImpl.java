package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist findByName(String name) {
        return artistRepository.findByName(name);
    }
    public Artist findById(Long id) {
        return artistRepository.findById(id);
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }
}
