
package com.svalero.museumexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("totalrecordsperquery")
    @Expose
    private Integer totalrecordsperquery;
    @SerializedName("totalrecords")
    @Expose
    private Integer totalrecords;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("responsetime")
    @Expose
    private String responsetime;

    public Integer getTotalrecordsperquery() {
        return totalrecordsperquery;
    }

    public void setTotalrecordsperquery(Integer totalrecordsperquery) {
        this.totalrecordsperquery = totalrecordsperquery;
    }

    public Integer getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(Integer totalrecords) {
        this.totalrecords = totalrecords;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(String responsetime) {
        this.responsetime = responsetime;
    }

}
