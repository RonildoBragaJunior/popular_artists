package com.redballoon.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redballoon.model.json.TopArtists;

import java.io.Serializable;


public class ResponseJSON implements Serializable{

    @JsonProperty("topartists")
    private TopArtists topArtistss;

    public TopArtists getTopArtistss() {
        return topArtistss;
    }

    public void setTopArtistss(TopArtists topArtistss) {
        this.topArtistss = topArtistss;
    }
}
