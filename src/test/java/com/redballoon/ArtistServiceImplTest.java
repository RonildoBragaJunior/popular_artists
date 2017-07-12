package com.redballoon;

import com.redballoon.model.Artist;
import com.redballoon.service.ArtistServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistServiceImplTest {

    @Autowired
    private ArtistServiceImpl artistServiceImpl;

    @Test
    public void saveArtistTest() throws Exception {
        Artist artist = new Artist();
        artist.setName("Radiohead");
        artist.setUrl("www.google.com.au");
        Artist entity = artistServiceImpl.saveArtist(artist);
        assert entity != null;
    }

    @Test
    public void cleanTest() throws Exception {
        artistServiceImpl.clean();
        assert true;
    }

}
