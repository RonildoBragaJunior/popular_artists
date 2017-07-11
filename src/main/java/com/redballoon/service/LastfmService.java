package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.json.LastfmArtists;

import java.util.List;

public interface LastfmService {

    public List<Artist> listArtistByCountry(String country);
}
