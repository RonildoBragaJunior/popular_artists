package com.redballoon.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.redballoon.model.Artist;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class LastfmArtists implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private String listeners;

    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Artist toArtist(){
        Artist artist = new Artist();
        artist.setName(name);
        artist.setUrl(url);
        return artist;
    }
}
