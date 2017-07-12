package com.redballoon.repository;

import com.redballoon.model.Listeners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("artistListenersRepository")
public interface ListenersRepository extends JpaRepository<Listeners, Long> {

}
