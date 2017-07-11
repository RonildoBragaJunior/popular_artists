package com.redballoon.controller;


public class SearchCriteria {

    String username;
    String email;
    String country;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "SearchCriteria [username=" + username + ", email=" + email + "]";
    }

}
