package com.sfeir.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import java.util.Set;

// This class exposes the api requests that can be called
@Path("/albums")
@ApplicationScoped
public class AlbumsResource {
    @Inject
    @RestClient
    AlbumsService albumsService;

    @GET
    @Path("")
    public Set<Album> getAll() {
        return albumsService.getAll();
    }

    @GET
    @Path("/{id}")
    public Album id(@PathParam int id) {
        return albumsService.getById(id);
    }

    @POST
    @Path("")
    public Set<Album> addAlbum(Album album) {
        albumsService.addAlbum(album);
        return albumsService.getAll();
    }

    @DELETE
    @Path("/{id}")
    public void deleteAlbum(@PathParam int id) {
        albumsService.deleteById(id);
    }
}
