package com.svalero.museumexplorer.task;

import com.svalero.museumexplorer.model.Data;
import com.svalero.museumexplorer.service.MuseumApiService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;

//TASK mostrar un objeto

public class LoadDataTask extends Task<Integer> {

    private Consumer<Data> consumer;
    private Integer size;
    private Integer page;
    private String apikey;

    public LoadDataTask(Integer size, Integer page, String apikey, Consumer<Data> consumer){
        this.size = size;
        this.page = page;
        this.apikey = apikey;
        this.consumer = consumer;
    }


    @Override
    protected Integer call() throws Exception {
        MuseumApiService museumApiService = new MuseumApiService();
        museumApiService.getAllObjects(size, page, apikey).subscribe(consumer);
        return null;
    }
}
