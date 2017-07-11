package com.redballoon;

import com.redballoon.model.Artist;
import com.redballoon.service.LastfmServiceImpl;
import com.redballoon.service.PopularArtistRankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LastfmServiceImplTest {

    @Autowired
    private LastfmServiceImpl lastfmServiceImpl;
    @Autowired
    private PopularArtistRankService popularArtistRankService;

    @Test
    public void listTopArtitstFromAustralia() throws Exception {
        List<Artist> lastfmArtistsList = lastfmServiceImpl.listTopArtistsByCountry("australia");
        for(Artist artistsList : lastfmArtistsList)
            System.out.println(artistsList.getName());
    }

    @Test
    public void listTopArtitstFromBrazil() throws Exception {
        List<Artist> lastfmArtistsList = lastfmServiceImpl.listTopArtistsByCountry("brazil");
        for(Artist artistsList : lastfmArtistsList)
            System.out.println(artistsList.getName());
    }


}
