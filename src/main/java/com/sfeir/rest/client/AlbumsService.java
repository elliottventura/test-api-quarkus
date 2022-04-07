package com.sfeir.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import java.util.Set;

// This class performs the rest call to the proxy
@Path("/albums")
@RegisterRestClient(configKey="test-api-proxy")
public interface AlbumsService {
    
    @GET
    @Path("")
    Set<Album> getAll();
    
    @GET
    @Path("/{id}")
    Album getById(@PathParam int id);
    
    @POST
    @Path("")
    Album addAlbum(Album album);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam int id);
}
