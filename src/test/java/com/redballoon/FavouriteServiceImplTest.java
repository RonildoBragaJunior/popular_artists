package com.redballoon;

import com.redballoon.model.Favourite;
import com.redballoon.model.User;
import com.redballoon.service.FavouriteServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavouriteServiceImplTest {

    @Autowired
    private FavouriteServiceImpl favouriteServiceImpl;

    public void listByUserTest(User user){

    }

    public void findFavouriteTest(Favourite favourite){

    }

    public void saveTest(String username, String[] id){

    }

    public void saveTest(Favourite favourite){

    }

    public void cleanTest(User user){

    }
}
