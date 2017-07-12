package com.redballoon.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "listeners")
public class Listeners {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "listeners_id")
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "listeners")
    private long listeners;

    @Column(name = "rank")
    private int rank;

    @ManyToOne
    private Artist artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getListeners() {
        return listeners;
    }

    public void setListeners(long listeners) {
        this.listeners = listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = Long.parseLong(listeners);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}

