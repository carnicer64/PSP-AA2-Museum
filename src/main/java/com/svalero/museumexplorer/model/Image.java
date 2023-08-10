
package com.svalero.museumexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("imageid")
    @Expose
    private Integer imageid;
    @SerializedName("idsid")
    @Expose
    private Integer idsid;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("technique")
    @Expose
    private Object technique;
    @SerializedName("renditionnumber")
    @Expose
    private String renditionnumber;
    @SerializedName("displayorder")
    @Expose
    private Integer displayorder;
    @SerializedName("baseimageurl")
    @Expose
    private String baseimageurl;
    @SerializedName("alttext")
    @Expose
    private Object alttext;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("publiccaption")
    @Expose
    private Object publiccaption;
    @SerializedName("iiifbaseuri")
    @Expose
    private String iiifbaseuri;
    @SerializedName("height")
    @Expose
    private Integer height;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public Integer getIdsid() {
        return idsid;
    }

    public void setIdsid(Integer idsid) {
        this.idsid = idsid;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getTechnique() {
        return technique;
    }

    public void setTechnique(Object technique) {
        this.technique = technique;
    }

    public String getRenditionnumber() {
        return renditionnumber;
    }

    public void setRenditionnumber(String renditionnumber) {
        this.renditionnumber = renditionnumber;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public String getBaseimageurl() {
        return baseimageurl;
    }

    public void setBaseimageurl(String baseimageurl) {
        this.baseimageurl = baseimageurl;
    }

    public Object getAlttext() {
        return alttext;
    }

    public void setAlttext(Object alttext) {
        this.alttext = alttext;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Object getPubliccaption() {
        return publiccaption;
    }

    public void setPubliccaption(Object publiccaption) {
        this.publiccaption = publiccaption;
    }

    public String getIiifbaseuri() {
        return iiifbaseuri;
    }

    public void setIiifbaseuri(String iiifbaseuri) {
        this.iiifbaseuri = iiifbaseuri;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
