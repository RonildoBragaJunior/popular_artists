package com.redballoon.service;


import com.redballoon.model.Artist;
import com.redballoon.model.PopularArtistRank;
import com.redballoon.repository.PopularArtistRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("popularArtistRankServiceImpl")
public class PopularArtistRankServiceImpl implements PopularArtistRankService{

    @Autowired
    private PopularArtistRankRepository popularArtistRankRepository;

    public PopularArtistRank findArtistRankByCountry(Artist artist, String country){
        return popularArtistRankRepository.findArtistRankByCountry(artist, country);
    }
    public void save(PopularArtistRank popularArtistRank){
        popularArtistRankRepository.save(popularArtistRank);
    }
}
