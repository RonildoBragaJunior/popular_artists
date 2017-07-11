package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.ArtistRank;


public interface PopularArtistRankService {

    public ArtistRank findArtistRankByCountry(Artist artist, String country);
    public void save(ArtistRank artistRank);
}
