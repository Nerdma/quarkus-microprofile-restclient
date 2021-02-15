package org.gs;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gs.model.TvSeries;
import org.gs.proxy.TvSeriesProxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/tvseries")
public class TvSeriesResource {

  @RestClient TvSeriesProxy proxy;

  private List<TvSeries> tvSeriesList = new ArrayList<>();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    TvSeries tvSeries = proxy.get("game of thrones");
    tvSeriesList.add(tvSeries);
    return Response.ok(tvSeriesList).build();
  }
}