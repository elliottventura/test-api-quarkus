package com.sfeir.rest.json;

public class Album {
    
    public int id;
    public String title;
    public String artiste;
    public float price;
    // Major major;

    public Album() {

    }

    public Album(int id, String title, String artiste, float price
    // , Major major
    ) {
        this.id = id;
        this.title = title;
        this.artiste = artiste;
        this.price = price;
        // this.major = major;
    }
}
