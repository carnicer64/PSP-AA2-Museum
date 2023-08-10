
package com.svalero.museumexplorer.model.buildings;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Building {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("records")
    @Expose
    private List<Record> records;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
