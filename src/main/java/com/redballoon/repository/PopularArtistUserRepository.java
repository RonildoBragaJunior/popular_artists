package com.redballoon.repository;

import com.redballoon.model.ArtistUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("popularArtistUserRepository")
public interface PopularArtistUserRepository extends JpaRepository<ArtistUser, Long> {
}
