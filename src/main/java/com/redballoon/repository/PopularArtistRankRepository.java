package com.redballoon.repository;

import com.redballoon.model.Artist;
import com.redballoon.model.PopularArtistRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("popularArtistRankRepository")
public interface PopularArtistRankRepository extends JpaRepository<PopularArtistRank, Long> {

    @Query("SELECT p FROM PopularArtistRank p WHERE p.artist = :artist and LOWER(p.country) = LOWER(:country)")
    PopularArtistRank findArtistRankByCountry(Artist artist, String country);

}
