package com.redballoon.service;


import com.redballoon.model.Artist;
import com.redballoon.model.Favourite;
import com.redballoon.model.User;
import com.redballoon.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("favouriteService")
public class FavouriteServiceImpl implements FavouriteService{

    @Autowired
    private ArtistService artistService;

    @Autowired
    private UserService userService;

    @Autowired
    private FavouriteRepository favouriteRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Favourite> listByUser(User user){
        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append(" SELECT table1 FROM Favourite table1");
        queryBuffer.append(" JOIN table1.user user");
        queryBuffer.append(" where user.id = :user_id");

        TypedQuery<Favourite> query = em.createQuery(queryBuffer.toString(), Favourite.class);
        query = query.setParameter("user_id", user.getId());
        return query.getResultList();
    }

    public Favourite findFavourite(Favourite favourite){
        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append(" SELECT table1 FROM Favourite table1");
        queryBuffer.append(" JOIN table1.artist artist");
        queryBuffer.append(" JOIN table1.user user");
        queryBuffer.append(" where artist.id = :artist_id and user.id = :user_id");

        TypedQuery<Favourite> query = em.createQuery(queryBuffer.toString(), Favourite.class);
        query = query.setParameter("artist_id", favourite.getArtist().getId());
        query = query.setParameter("user_id", favourite.getUser().getId());

        try {
            return query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }

    public void save(String username, String[] id){
        User user = userService.findUserByEmail(username);

        for(int i = 0; i < id.length; i++){
            Artist artist = artistService.findById(Long.parseLong(id[i]));
            Favourite favourite = new Favourite();
            favourite.setArtist(artist);
            favourite.setUser(user);

            if(findFavourite(favourite) == null)
                favouriteRepository.save(favourite);
        }
    }

    public void save(Favourite favourite){
        favouriteRepository.save(favourite);
    }


}