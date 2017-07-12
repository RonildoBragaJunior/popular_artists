package com.redballoon.service;

import com.redballoon.model.Favourite;
import com.redballoon.model.User;

import java.util.List;

public interface FavouriteService {

    public List<Favourite> listByUser(User user);

    public Favourite findFavourite(Favourite favourite);

    public void save(String username, String[] id);

    public void save(Favourite favourite);

    public void clean(User user);
}
