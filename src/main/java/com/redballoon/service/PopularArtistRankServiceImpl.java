package com.redballoon.service;


import com.redballoon.model.Artist;
import com.redballoon.model.ArtistRank;
import com.redballoon.repository.PopularArtistRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service("popularArtistRankServiceImpl")
public class PopularArtistRankServiceImpl implements PopularArtistRankService{

    @Autowired
    private PopularArtistRankRepository popularArtistRankRepository;
    @PersistenceContext
    private EntityManager em;

    public ArtistRank findArtistRankByCountry(Artist artist, String country){
        TypedQuery<ArtistRank> query = em.createQuery("select rank from ArtistRank rank join rank.artist artist where rank.country = :country and artist.name = :name", ArtistRank.class);
        query = query.setParameter("country", country);
        query = query.setParameter("name", artist.getName());

        try {
            return query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }

    }
    public void save(ArtistRank artistRank){
        popularArtistRankRepository.save(artistRank);
    }
}
