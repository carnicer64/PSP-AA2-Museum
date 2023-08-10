
package com.svalero.museumexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coins {

    @SerializedName("reverseinscription")
    @Expose
    private Object reverseinscription;
    @SerializedName("dieaxis")
    @Expose
    private String dieaxis;
    @SerializedName("metal")
    @Expose
    private String metal;
    @SerializedName("obverseinscription")
    @Expose
    private Object obverseinscription;
    @SerializedName("denomination")
    @Expose
    private Object denomination;
    @SerializedName("dateonobject")
    @Expose
    private Object dateonobject;

    public Object getReverseinscription() {
        return reverseinscription;
    }

    public void setReverseinscription(Object reverseinscription) {
        this.reverseinscription = reverseinscription;
    }

    public String getDieaxis() {
        return dieaxis;
    }

    public void setDieaxis(String dieaxis) {
        this.dieaxis = dieaxis;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public Object getObverseinscription() {
        return obverseinscription;
    }

    public void setObverseinscription(Object obverseinscription) {
        this.obverseinscription = obverseinscription;
    }

    public Object getDenomination() {
        return denomination;
    }

    public void setDenomination(Object denomination) {
        this.denomination = denomination;
    }

    public Object getDateonobject() {
        return dateonobject;
    }

    public void setDateonobject(Object dateonobject) {
        this.dateonobject = dateonobject;
    }

}
