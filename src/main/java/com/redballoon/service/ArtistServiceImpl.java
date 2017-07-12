package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.User;
import com.redballoon.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @PersistenceContext
    private EntityManager em;

    public Artist findByName(String name) {
        return artistRepository.findByName(name);
    }
    public Artist findById(Long id) {
        return artistRepository.findById(id);
    }
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Transactional
    public void clean(){
        Query queryListeners = em.createQuery("delete FROM Listeners listeners");
        queryListeners.executeUpdate();

        Query queryArtists = em.createQuery("delete FROM Artist artist");
        queryArtists.executeUpdate();
    }
}