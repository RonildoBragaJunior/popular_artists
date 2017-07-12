package com.redballoon.service;

import com.redballoon.model.ArtistUser;
import com.redballoon.model.User;

import java.util.List;

public interface FavouriteArtistService {

    public void save(User user, String id);
    public void save(ArtistUser favourite);
    public List<ArtistUser> listFavouriteByUser(String country);
}
