package com.redballoon.service;

import com.redballoon.model.json.LastfmArtists;
import com.redballoon.model.json.ResponseJSON;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class LastfmServiceImpl implements LastfmService{

    private final String API_KEY = "2a8afd03aa6c17e37847a6fd79b0eaad";

    public List<LastfmArtists> listTopArtistsByCountry(String country) {

        RestTemplate restTemplate = new RestTemplate();

        StringBuilder url = new StringBuilder();
        url.append("http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=");
        url.append(country);
        url.append("&api_key="+API_KEY);
        url.append("&format=json");

        ResponseEntity<ResponseJSON> response = restTemplate.getForEntity(url.toString(), ResponseJSON.class, 200);

        if (response != null && response.getBody() != null && response.getBody().getTopArtistss() != null )
            return response.getBody().getTopArtistss().getLastfmArtistsList();

        throw new RuntimeException("Web service is out");
    }
}
