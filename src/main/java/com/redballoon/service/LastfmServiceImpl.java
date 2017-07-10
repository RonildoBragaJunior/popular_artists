package com.redballoon.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

@Component
public class LastfmServiceImpl implements LastfmService{

    private final String API_KEY = "2a8afd03aa6c17e37847a6fd79b0eaad";

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    //TODO: Parse data to a list of objects
    private List<LastfmArtists> parseJSON(String data){
        System.out.println("You are almost there");
        System.out.println(data);
        List<LastfmArtists> lastfmArtistsList = new LinkedList<LastfmArtists>();
        return lastfmArtistsList;
    }

    public List<LastfmArtists> listArtistsByCountry(String country){
        try {
            JSONObject json = readJsonFromUrl("http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=australia&api_key=2a8afd03aa6c17e37847a6fd79b0eaad&format=json");
            return parseJSON(json.toString());
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}