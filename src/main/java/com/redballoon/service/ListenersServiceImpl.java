package com.redballoon.service;


import com.redballoon.model.Artist;
import com.redballoon.model.Listeners;
import com.redballoon.repository.ListenersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("artistListenersServiceImpl")
public class ListenersServiceImpl implements ListenersService {

    @Autowired
    private ListenersRepository listenersRepository;
    @PersistenceContext
    private EntityManager em;

    public Listeners findListenersByCountry(Artist artist, String country){
        TypedQuery<Listeners> query = em.createQuery("select rank from Listeners rank join rank.artist artist where rank.country = :country and artist.name = :name", Listeners.class);
        query = query.setParameter("country", country);
        query = query.setParameter("name", artist.getName());

        try {
            return query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }

    }

    public List<Listeners> listListenersByCountry(String country){
        TypedQuery<Listeners> query = em.createQuery("select rank from Listeners rank join rank.artist artist where rank.country = :country", Listeners.class);
        query = query.setParameter("country", country);
        return query.getResultList();
    }

    public void save(Listeners listeners){
        listenersRepository.save(listeners);
    }
}
