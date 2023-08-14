package com.svalero.museumexplorer.task;

import com.svalero.museumexplorer.service.MuseumApiService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;
import com.svalero.museumexplorer.model.Record;

public class LoadRecordsTask extends Task<Integer> {

    private Consumer<Record> consumer;
    private Integer size;
    private Integer page;
    private String apikey;

    public LoadRecordsTask(Integer size, Integer page, String apikey, Consumer<Record> consumer){
        this.size = size;
        this.page = page;
        this.apikey = apikey;
        this.consumer = consumer;
    }


    @Override
    protected Integer call() throws Exception {
        MuseumApiService museumApiService = new MuseumApiService();
        museumApiService.getAllRecords(size, page, apikey).subscribe(consumer);
        return null;
    }
}
