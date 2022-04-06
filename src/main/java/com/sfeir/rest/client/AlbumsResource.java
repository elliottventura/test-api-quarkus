package com.sfeir.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/albums")
@ApplicationScoped
public class AlbumsResource {
    @Inject
    @RestClient
    AlbumsService albumsService;

    @GET
    @Path("/id/{id}")
    public Set<Album> id(@PathParam String id) {
        return albumsService.getById(id);
    }

    @GET
    @Path("")
    public Set<Album> getAll() {
        return albumsService.getAll();
    }

    @POST
    @Path("")
    public Set<Album> addAlbum(Album album) {
        albumsService.addAlbum(album);
        return albumsService.getAll();
    }
}
