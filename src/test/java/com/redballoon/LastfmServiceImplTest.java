package com.redballoon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.redballoon.service.LastfmServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LastfmServiceImplTest {

    @Autowired
    private LastfmServiceImpl lastfmServiceImpl;

    @Test
    public void listArtistsByCountry() throws Exception {
        lastfmServiceImpl.listArtistsByCountry("australia");
    }
}
