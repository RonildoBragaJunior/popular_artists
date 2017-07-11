package com.redballoon.model;


import javax.persistence.*;

@Entity
@Table(name = "popular_artist_user")
public class ArtistUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "popular_artist_user_id")
    private int id;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
