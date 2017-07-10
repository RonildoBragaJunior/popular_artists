package com.redballoon.repository;

import com.redballoon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.redballoon.model.Artist;

@Repository("artistRepository")
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
