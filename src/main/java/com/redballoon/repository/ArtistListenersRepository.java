package com.redballoon.repository;

import com.redballoon.model.ArtistListeners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("artistListenersRepository")
public interface ArtistListenersRepository extends JpaRepository<ArtistListeners, Long> {

}
