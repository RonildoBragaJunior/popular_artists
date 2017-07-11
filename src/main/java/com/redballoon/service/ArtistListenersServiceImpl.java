package com.redballoon.service;


import com.redballoon.model.Artist;
import com.redballoon.model.ArtistListeners;
import com.redballoon.repository.ArtistListenersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("artistListenersServiceImpl")
public class ArtistListenersServiceImpl implements ArtistListenersService {

    @Autowired
    private ArtistListenersRepository artistListenersRepository;
    @PersistenceContext
    private EntityManager em;

    public ArtistListeners findArtistListenersByCountry(Artist artist, String country){
        TypedQuery<ArtistListeners> query = em.createQuery("select rank from ArtistListeners rank join rank.artist artist where rank.country = :country and artist.name = :name", ArtistListeners.class);
        query = query.setParameter("country", country);
        query = query.setParameter("name", artist.getName());

        try {
            return query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }

    }

    public List<ArtistListeners> listArtistListenersByCountry(String country){
        TypedQuery<ArtistListeners> query = em.createQuery("select rank from ArtistListeners rank join rank.artist artist where rank.country = :country", ArtistListeners.class);
        query = query.setParameter("country", country);
        return query.getResultList();
    }

    public void save(ArtistListeners artistListeners){
        artistListenersRepository.save(artistListeners);
    }
}
