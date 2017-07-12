package com.redballoon;

import com.redballoon.model.Artist;
import com.redballoon.service.ArtistServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistServiceImplTest {

    private final String ARTIST_NAME = "Radiohead";
    private final String ARTIST_URL = "www.google.com.au";

    @Autowired
    private ArtistServiceImpl artistServiceImpl;

    @Test
    public void saveArtistTest() throws Exception {
        Artist artist = new Artist();
        artist.setName(ARTIST_NAME);
        artist.setUrl(ARTIST_URL);
        Artist entity = artistServiceImpl.saveArtist(artist);
        assertThat(entity).isNotNull();
    }

    @Test
    public void findByNameTest() throws Exception {
        Artist artist = artistServiceImpl.findByName(ARTIST_NAME);
        assertThat(artist.getName()).isEqualTo(ARTIST_NAME);
    }

    @Test
    public void cleanTest() throws Exception {
        artistServiceImpl.clean();
        List<Artist> list = artistServiceImpl.findAll();
        assert  list.isEmpty();
    }

}
