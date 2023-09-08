package com.svalero.museumexplorer.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svalero.museumexplorer.model.Data;
import com.svalero.museumexplorer.model.Record;
import com.svalero.museumexplorer.model.buildings.Building;
import io.reactivex.Observable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MuseumApiService {
    private  MuseumApi museumApi;
    private String url = "https://api.harvardartmuseums.org";

    public MuseumApiService(){
        HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gsonParser = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit museumApi = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonParser))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        this.museumApi = museumApi.create(MuseumApi.class);

    }

    public Observable<Data> getAllObjects(Integer size, Integer page, String apikey){
        return this.museumApi.getData(size, page, apikey);
    }

    public Observable<Record> getAllRecords(Integer size, Integer page, String apikey){
        return this.museumApi.getData(size, page, apikey).map(Data::getRecords).flatMapIterable(records -> records);
    }

    public Observable<Building> getAllBuildings(Integer size, Integer page, String apikey){
        return this.museumApi.getBuildings(size, page, apikey);
    }
}
