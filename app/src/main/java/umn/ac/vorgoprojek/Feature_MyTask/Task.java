package umn.ac.vorgoprojek.Feature_MyTask;

import java.util.Date;

public class Task {
    private String edtFor, edtIn, edtTaskName, edtDesc, edtMember, edtDate, currUser;

    public Task() {
    }

    public String getEdtFor() {
        return edtFor;
    }

    public void setEdtFor(String edtFor) {
        this.edtFor = edtFor;
    }

    public String getEdtIn() {
        return edtIn;
    }

    public void setEdtIn(String edtIn) {
        this.edtIn = edtIn;
    }

    public String getEdtTaskName() {
        return edtTaskName;
    }

    public void setEdtTaskName(String edtTaskName) {
        this.edtTaskName = edtTaskName;
    }

    public String getEdtDesc() {
        return edtDesc;
    }

    public void setEdtDesc(String edtDesc) {
        this.edtDesc = edtDesc;
    }

    public String getEdtMember() {
        return edtMember;
    }

    public void setEdtMember(String edtMember) {
        this.edtMember = edtMember;
    }

    public String getEdtDate() {
        return edtDate;
    }

    public void setEdtDate(String edtDate) {
        this.edtDate = edtDate;
    }


    public String getCurrUser() {
        return currUser;
    }

    public void setCurrUser(String currUser) {
        this.currUser = currUser;
    }
}
