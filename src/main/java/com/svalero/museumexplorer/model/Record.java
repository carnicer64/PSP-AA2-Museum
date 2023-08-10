
package com.svalero.museumexplorer.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {

    @SerializedName("copyright")
    @Expose
    private Object copyright;
    @SerializedName("contextualtextcount")
    @Expose
    private Integer contextualtextcount;
    @SerializedName("creditline")
    @Expose
    private String creditline;
    @SerializedName("accesslevel")
    @Expose
    private Integer accesslevel;
    @SerializedName("dateoflastpageview")
    @Expose
    private String dateoflastpageview;
    @SerializedName("classificationid")
    @Expose
    private Integer classificationid;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("markscount")
    @Expose
    private Integer markscount;
    @SerializedName("publicationcount")
    @Expose
    private Integer publicationcount;
    @SerializedName("totaluniquepageviews")
    @Expose
    private Integer totaluniquepageviews;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("colorcount")
    @Expose
    private Integer colorcount;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("verificationleveldescription")
    @Expose
    private String verificationleveldescription;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("images")
    @Expose
    private List<Image> images;
    @SerializedName("worktypes")
    @Expose
    private List<Worktype> worktypes;
    @SerializedName("imagecount")
    @Expose
    private Integer imagecount;
    @SerializedName("totalpageviews")
    @Expose
    private Integer totalpageviews;
    @SerializedName("accessionyear")
    @Expose
    private Integer accessionyear;
    @SerializedName("standardreferencenumber")
    @Expose
    private String standardreferencenumber;
    @SerializedName("signed")
    @Expose
    private Object signed;
    @SerializedName("classification")
    @Expose
    private String classification;
    @SerializedName("relatedcount")
    @Expose
    private Integer relatedcount;
    @SerializedName("verificationlevel")
    @Expose
    private Integer verificationlevel;
    @SerializedName("primaryimageurl")
    @Expose
    private String primaryimageurl;
    @SerializedName("titlescount")
    @Expose
    private Integer titlescount;
    @SerializedName("peoplecount")
    @Expose
    private Integer peoplecount;
    @SerializedName("style")
    @Expose
    private Object style;
    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;
    @SerializedName("commentary")
    @Expose
    private Object commentary;
    @SerializedName("periodid")
    @Expose
    private Integer periodid;
    @SerializedName("technique")
    @Expose
    private String technique;
    @SerializedName("edition")
    @Expose
    private Object edition;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("lendingpermissionlevel")
    @Expose
    private Integer lendingpermissionlevel;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("accessionmethod")
    @Expose
    private String accessionmethod;
    @SerializedName("colors")
    @Expose
    private List<Color> colors;
    @SerializedName("provenance")
    @Expose
    private String provenance;
    @SerializedName("groupcount")
    @Expose
    private Integer groupcount;
    @SerializedName("dated")
    @Expose
    private String dated;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("dateend")
    @Expose
    private Integer dateend;
    @SerializedName("people")
    @Expose
    private List<Person> people;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("dateoffirstpageview")
    @Expose
    private String dateoffirstpageview;
    @SerializedName("century")
    @Expose
    private String century;
    @SerializedName("objectnumber")
    @Expose
    private String objectnumber;
    @SerializedName("labeltext")
    @Expose
    private Object labeltext;
    @SerializedName("datebegin")
    @Expose
    private Integer datebegin;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("exhibitioncount")
    @Expose
    private Integer exhibitioncount;
    @SerializedName("imagepermissionlevel")
    @Expose
    private Integer imagepermissionlevel;
    @SerializedName("mediacount")
    @Expose
    private Integer mediacount;
    @SerializedName("objectid")
    @Expose
    private Integer objectid;
    @SerializedName("techniqueid")
    @Expose
    private Integer techniqueid;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;
    @SerializedName("seeAlso")
    @Expose
    private List<SeeAlso> seeAlso;
    @SerializedName("details")
    @Expose
    private Details details;

    public Object getCopyright() {
        return copyright;
    }

    public void setCopyright(Object copyright) {
        this.copyright = copyright;
    }

    public Integer getContextualtextcount() {
        return contextualtextcount;
    }

    public void setContextualtextcount(Integer contextualtextcount) {
        this.contextualtextcount = contextualtextcount;
    }

    public String getCreditline() {
        return creditline;
    }

    public void setCreditline(String creditline) {
        this.creditline = creditline;
    }

    public Integer getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(Integer accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getDateoflastpageview() {
        return dateoflastpageview;
    }

    public void setDateoflastpageview(String dateoflastpageview) {
        this.dateoflastpageview = dateoflastpageview;
    }

    public Integer getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(Integer classificationid) {
        this.classificationid = classificationid;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Integer getMarkscount() {
        return markscount;
    }

    public void setMarkscount(Integer markscount) {
        this.markscount = markscount;
    }

    public Integer getPublicationcount() {
        return publicationcount;
    }

    public void setPublicationcount(Integer publicationcount) {
        this.publicationcount = publicationcount;
    }

    public Integer getTotaluniquepageviews() {
        return totaluniquepageviews;
    }

    public void setTotaluniquepageviews(Integer totaluniquepageviews) {
        this.totaluniquepageviews = totaluniquepageviews;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getColorcount() {
        return colorcount;
    }

    public void setColorcount(Integer colorcount) {
        this.colorcount = colorcount;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public String getVerificationleveldescription() {
        return verificationleveldescription;
    }

    public void setVerificationleveldescription(String verificationleveldescription) {
        this.verificationleveldescription = verificationleveldescription;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Worktype> getWorktypes() {
        return worktypes;
    }

    public void setWorktypes(List<Worktype> worktypes) {
        this.worktypes = worktypes;
    }

    public Integer getImagecount() {
        return imagecount;
    }

    public void setImagecount(Integer imagecount) {
        this.imagecount = imagecount;
    }

    public Integer getTotalpageviews() {
        return totalpageviews;
    }

    public void setTotalpageviews(Integer totalpageviews) {
        this.totalpageviews = totalpageviews;
    }

    public Integer getAccessionyear() {
        return accessionyear;
    }

    public void setAccessionyear(Integer accessionyear) {
        this.accessionyear = accessionyear;
    }

    public String getStandardreferencenumber() {
        return standardreferencenumber;
    }

    public void setStandardreferencenumber(String standardreferencenumber) {
        this.standardreferencenumber = standardreferencenumber;
    }

    public Object getSigned() {
        return signed;
    }

    public void setSigned(Object signed) {
        this.signed = signed;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getRelatedcount() {
        return relatedcount;
    }

    public void setRelatedcount(Integer relatedcount) {
        this.relatedcount = relatedcount;
    }

    public Integer getVerificationlevel() {
        return verificationlevel;
    }

    public void setVerificationlevel(Integer verificationlevel) {
        this.verificationlevel = verificationlevel;
    }

    public String getPrimaryimageurl() {
        return primaryimageurl;
    }

    public void setPrimaryimageurl(String primaryimageurl) {
        this.primaryimageurl = primaryimageurl;
    }

    public Integer getTitlescount() {
        return titlescount;
    }

    public void setTitlescount(Integer titlescount) {
        this.titlescount = titlescount;
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public Object getStyle() {
        return style;
    }

    public void setStyle(Object style) {
        this.style = style;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Object getCommentary() {
        return commentary;
    }

    public void setCommentary(Object commentary) {
        this.commentary = commentary;
    }

    public Integer getPeriodid() {
        return periodid;
    }

    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public Object getEdition() {
        return edition;
    }

    public void setEdition(Object edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Integer getLendingpermissionlevel() {
        return lendingpermissionlevel;
    }

    public void setLendingpermissionlevel(Integer lendingpermissionlevel) {
        this.lendingpermissionlevel = lendingpermissionlevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccessionmethod() {
        return accessionmethod;
    }

    public void setAccessionmethod(String accessionmethod) {
        this.accessionmethod = accessionmethod;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public Integer getGroupcount() {
        return groupcount;
    }

    public void setGroupcount(Integer groupcount) {
        this.groupcount = groupcount;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDateend() {
        return dateend;
    }

    public void setDateend(Integer dateend) {
        this.dateend = dateend;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDateoffirstpageview() {
        return dateoffirstpageview;
    }

    public void setDateoffirstpageview(String dateoffirstpageview) {
        this.dateoffirstpageview = dateoffirstpageview;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }

    public String getObjectnumber() {
        return objectnumber;
    }

    public void setObjectnumber(String objectnumber) {
        this.objectnumber = objectnumber;
    }

    public Object getLabeltext() {
        return labeltext;
    }

    public void setLabeltext(Object labeltext) {
        this.labeltext = labeltext;
    }

    public Integer getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(Integer datebegin) {
        this.datebegin = datebegin;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public Integer getExhibitioncount() {
        return exhibitioncount;
    }

    public void setExhibitioncount(Integer exhibitioncount) {
        this.exhibitioncount = exhibitioncount;
    }

    public Integer getImagepermissionlevel() {
        return imagepermissionlevel;
    }

    public void setImagepermissionlevel(Integer imagepermissionlevel) {
        this.imagepermissionlevel = imagepermissionlevel;
    }

    public Integer getMediacount() {
        return mediacount;
    }

    public void setMediacount(Integer mediacount) {
        this.mediacount = mediacount;
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public Integer getTechniqueid() {
        return techniqueid;
    }

    public void setTechniqueid(Integer techniqueid) {
        this.techniqueid = techniqueid;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public List<SeeAlso> getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(List<SeeAlso> seeAlso) {
        this.seeAlso = seeAlso;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

}
