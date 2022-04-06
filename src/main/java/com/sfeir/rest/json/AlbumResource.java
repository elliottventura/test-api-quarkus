package com.sfeir.rest.json;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

// The html page to list and add fruits is located here : http://localhost:8081/albums.html
@Path("/albums")
public class AlbumResource {

    private Set<Album> albums = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public AlbumResource() {
        albums.add(new Album(0, "Green Train", "Jane Coltrane", 25.99f));
        albums.add(new Album(1, "Jena", "Tom Mulligan", 15.99f));
    }

    @GET
    public Set<Album> list() {
        return albums;
    }

    @POST
    public Set<Album> add(Album album) {
        int newId = albums.size();
        albums.add(new Album(newId, album.title, album.artiste, album.price));
        return albums;
    }

    @DELETE
    public Set<Album> delete(Album album) {
        albums.removeIf(existingAlbum -> existingAlbum.title.contentEquals(album.title));
        return albums;
    }
}