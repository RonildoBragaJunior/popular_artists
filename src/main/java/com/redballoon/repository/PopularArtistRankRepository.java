package com.redballoon.repository;

import com.redballoon.model.PopularArtistRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("popularArtistRankRepository")
public interface PopularArtistRankRepository extends JpaRepository<PopularArtistRank, Long> {
}
