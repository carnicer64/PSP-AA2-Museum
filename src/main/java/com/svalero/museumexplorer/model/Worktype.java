
package com.svalero.museumexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Worktype {

    @SerializedName("worktypeid")
    @Expose
    private String worktypeid;
    @SerializedName("worktype")
    @Expose
    private String worktype;

    public String getWorktypeid() {
        return worktypeid;
    }

    public void setWorktypeid(String worktypeid) {
        this.worktypeid = worktypeid;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

}
