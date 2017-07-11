package com.redballoon.model.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.redballoon.model.json.LastfmArtists;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopArtists implements Serializable{

    @JsonProperty("artist")
    public List<LastfmArtists> lastfmArtistsList;

    public List<LastfmArtists> getLastfmArtistsList() {
        return lastfmArtistsList;
    }

    public void setLastfmArtistsList(List<LastfmArtists> lastfmArtistsList) {
        this.lastfmArtistsList = lastfmArtistsList;
    }
}
