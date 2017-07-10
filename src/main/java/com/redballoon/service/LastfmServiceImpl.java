package com.redballoon.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Arrays;

@Component
public class LastfmServiceImpl implements LastfmService{

    private final String API_KEY = "2a8afd03aa6c17e37847a6fd79b0eaad";

    public List<LastfmArtists> listArtistsByCountry(String country) {

        List<LastfmArtists> resultList = null;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<LastfmArtists[]> lastfmArtistsList =
                restTemplate.getForEntity("http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=australia&api_key=2a8afd03aa6c17e37847a6fd79b0eaad&format=json",
                        LastfmArtists[].class, 200);

        if (lastfmArtistsList != null && lastfmArtistsList.getBody() != null) {
            resultList = Arrays.asList(lastfmArtistsList.getBody());
        }

        return resultList;
    }
}
