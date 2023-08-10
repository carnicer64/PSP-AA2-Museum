package com.svalero.museumexplorer.task;

import com.svalero.museumexplorer.model.buildings.Building;
import com.svalero.museumexplorer.service.MuseumApi;
import com.svalero.museumexplorer.service.MuseumApiService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;

public class LoadBuildingTask extends Task<Integer> {

    private Consumer<Building> consumer;
    private Integer size;
    private Integer page;
    private String apikey;

    public LoadBuildingTask(Consumer<Building> consumer, Integer size, Integer page, String apikey) {
        this.consumer = consumer;
        this.size = size;
        this.page = page;
        this.apikey = apikey;
    }

    @Override
    protected Integer call() throws Exception {
        MuseumApiService museumApiService = new MuseumApiService();
        museumApiService.getAllBuildings(size, page, apikey).subscribe(consumer);
        return null;
    }
}

