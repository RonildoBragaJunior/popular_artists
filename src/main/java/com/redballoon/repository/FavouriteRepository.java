package com.redballoon.repository;

import com.redballoon.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("favouriteArtistRepository")
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
}
