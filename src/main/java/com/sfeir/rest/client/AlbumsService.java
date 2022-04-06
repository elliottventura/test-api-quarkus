package com.sfeir.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/albums")
@RegisterRestClient(configKey="test-api-go")
public interface AlbumsService {
    @GET
    Set<Album> getById(@QueryParam String id);

    @GET
    @Path("")
    Set<Album> getAll();

    @POST
    @Path("")
    Album addAlbum(Album album);
}
