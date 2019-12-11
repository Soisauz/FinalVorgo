package umn.ac.vorgoprojek.Feature_MyTask;

import java.util.Date;

public class Task {

    public Task() {
    }

    private String taskfor, taskin, taskname, taskdesc, taskmember, taskdate, currUser;

    public String getTaskfor() {
        return taskfor;
    }

    public void setTaskfor(String taskfor) {
        this.taskfor = taskfor;
    }

    public String getTaskin() {
        return taskin;
    }

    public void setTaskin(String taskin) {
        this.taskin = taskin;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

    public String getTaskmember() {
        return taskmember;
    }

    public void setTaskmember(String taskmember) {
        this.taskmember = taskmember;
    }

    public String getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(String taskdate) {
        this.taskdate = taskdate;
    }

    public String getCurrUser() {
        return currUser;
    }

    public void setCurrUser(String currUser) {
        this.currUser = currUser;
    }
}
