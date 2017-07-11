package com.redballoon.repository;

import com.redballoon.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("artistRepository")
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);
}
