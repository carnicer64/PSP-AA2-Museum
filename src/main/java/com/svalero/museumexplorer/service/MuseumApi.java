package com.svalero.museumexplorer.service;

import com.svalero.museumexplorer.model.Data;
import com.svalero.museumexplorer.model.buildings.Building;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MuseumApi {
    @GET("object")
    Observable<Data> getData(@Query("size") Integer size,
                             @Query("page") Integer page,
                             @Query("apikey") String apikey);
    @GET("site")
    Observable<Building> getBuildings(@Query("size") Integer size,
                                      @Query("page") Integer page,
                                      @Query("apikey") String apikey);
}
