package com.redballoon.repository;

import com.redballoon.model.ArtistRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("popularArtistRankRepository")
public interface PopularArtistRankRepository extends JpaRepository<ArtistRank, Long> {

}
