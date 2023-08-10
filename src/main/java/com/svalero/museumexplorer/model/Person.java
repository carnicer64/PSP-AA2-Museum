
package com.svalero.museumexplorer.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("birthplace")
    @Expose
    private Object birthplace;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("displaydate")
    @Expose
    private String displaydate;
    @SerializedName("prefix")
    @Expose
    private Object prefix;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("displayname")
    @Expose
    private String displayname;
    @SerializedName("alphasort")
    @Expose
    private String alphasort;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("personid")
    @Expose
    private Integer personid;
    @SerializedName("deathplace")
    @Expose
    private Object deathplace;
    @SerializedName("displayorder")
    @Expose
    private Integer displayorder;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Object getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Object birthplace) {
        this.birthplace = birthplace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisplaydate() {
        return displaydate;
    }

    public void setDisplaydate(String displaydate) {
        this.displaydate = displaydate;
    }

    public Object getPrefix() {
        return prefix;
    }

    public void setPrefix(Object prefix) {
        this.prefix = prefix;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getAlphasort() {
        return alphasort;
    }

    public void setAlphasort(String alphasort) {
        this.alphasort = alphasort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Object getDeathplace() {
        return deathplace;
    }

    public void setDeathplace(Object deathplace) {
        this.deathplace = deathplace;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

}
