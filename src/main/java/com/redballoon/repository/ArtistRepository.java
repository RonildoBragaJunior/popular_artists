package com.redballoon.repository;

import com.redballoon.model.Artist;
import com.redballoon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("artistRepository")
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);
    Artist findById(Long id);
}
