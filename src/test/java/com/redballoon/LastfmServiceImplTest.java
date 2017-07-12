package com.redballoon;

import com.redballoon.model.Artist;
import com.redballoon.service.LastfmServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LastfmServiceImplTest {

    @Autowired
    private LastfmServiceImpl lastfmServiceImpl;

    @Test
    public void listTopArtitstFromAustralia() throws Exception {
        List<Artist> lastfmArtistsList = lastfmServiceImpl.consumeLastfmWebservice("australia");
        assertThat(lastfmArtistsList).isNotNull();
        for(Artist artistsList : lastfmArtistsList)
            assertThat(artistsList).isNotNull();
    }

    @Test
    public void listTopArtitstFromBrazil() throws Exception {
        List<Artist> lastfmArtistsList = lastfmServiceImpl.consumeLastfmWebservice("brazil");
        assertThat(lastfmArtistsList).isNotNull();
        for(Artist artistsList : lastfmArtistsList)
            assertThat(artistsList).isNotNull();
    }
}
