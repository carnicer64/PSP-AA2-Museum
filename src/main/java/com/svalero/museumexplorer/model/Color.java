
package com.svalero.museumexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color {

    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("spectrum")
    @Expose
    private String spectrum;
    @SerializedName("hue")
    @Expose
    private String hue;
    @SerializedName("percent")
    @Expose
    private Double percent;
    @SerializedName("css3")
    @Expose
    private String css3;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpectrum() {
        return spectrum;
    }

    public void setSpectrum(String spectrum) {
        this.spectrum = spectrum;
    }

    public String getHue() {
        return hue;
    }

    public void setHue(String hue) {
        this.hue = hue;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getCss3() {
        return css3;
    }

    public void setCss3(String css3) {
        this.css3 = css3;
    }

}
