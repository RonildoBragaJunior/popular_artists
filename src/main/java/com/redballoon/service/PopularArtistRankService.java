package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.PopularArtistRank;


public interface PopularArtistRankService {

    public PopularArtistRank findArtistRankByCountry(Artist artist, String country);
    public void save(PopularArtistRank popularArtistRank);
}
