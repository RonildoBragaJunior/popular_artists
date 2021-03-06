package com.redballoon.service;

import com.redballoon.model.Artist;
import com.redballoon.model.Listeners;
import com.redballoon.model.json.LastfmArtists;
import com.redballoon.model.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service("lastfmService")
public class LastfmServiceImpl implements LastfmService{

    private final String API_KEY = "2a8afd03aa6c17e37847a6fd79b0eaad";

    @Autowired
    private ArtistService artistService;
    @Autowired
    private ListenersService listenersService;

    private List<Artist> persistResponse(List<LastfmArtists> lastfmArtistsList, String country){
        List<Artist> artistList = new LinkedList<Artist>();
        for(LastfmArtists lastfmArtists : lastfmArtistsList){
            Artist artist = artistService.findByName(lastfmArtists.getName());

            if(artist == null){
                artist = lastfmArtists.toArtist();
                artist = artistService.saveArtist(artist);

            }

            Listeners listeners = listenersService.findByCountry(artist, country);
            if(listeners == null){
                listeners = new Listeners();
                listeners.setArtist(artist);
                listeners.setCountry(country);
                listeners.setListeners(lastfmArtists.getListeners());
                listenersService.save(listeners);
            }

            artistList.add(artist);
        }
        return artistList;
    }

    public List<Artist> consumeLastfmWebservice(String country) {

        RestTemplate restTemplate = new RestTemplate();

        StringBuilder url = new StringBuilder();
        url.append("http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=");
        url.append(country);
        url.append("&api_key="+API_KEY);
        url.append("&format=json");

        ResponseEntity<ResponseJSON> response = restTemplate.getForEntity(url.toString(), ResponseJSON.class, 200);

        if (response != null && response.getBody() != null && response.getBody().getTopArtistss() != null ) {
            List<LastfmArtists> lastfmArtistsList = response.getBody().getTopArtistss().getLastfmArtistsList();
            return persistResponse(lastfmArtistsList, country);
        }

        return null;
    }
}
