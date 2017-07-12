package com.redballoon.service;

import com.redballoon.model.Favourite;
import com.redballoon.model.User;

import java.util.List;

public interface FavouriteService {

    public void save(User user, String id);
    public void save(Favourite favourite);
    public List<Favourite> listFavouriteByUser(String country);
}
