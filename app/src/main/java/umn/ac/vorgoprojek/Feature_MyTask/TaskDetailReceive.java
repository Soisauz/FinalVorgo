package umn.ac.vorgoprojek.Feature_MyTask;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Avin on 08/08/2018.
 */

public class TaskDetailReceive {
    public String taskname;
    public String taskdesc;
    public String taskfor;
    public String taskdate;
    public String taskmember;
    public String taskin;
    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskname() { return taskname; }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

    public String getTaskfor() {
        return taskfor;
    }

    public void setTaskfor(String taskfor) {
        this.taskfor = taskfor;
    }

    public String getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(String taskdate) {
        this.taskdate = taskdate;
    }

    public String getTaskmember() {
        return taskmember;
    }

    public void setTaskmember(String taskmember) {
        this.taskmember = taskmember;
    }

    public String getTaskin() {
        return taskin;
    }

    public void setTaskin(String taskin) {
        this.taskin = taskin;
    }

    public TaskDetailReceive() {
    }

/*    public TaskDetailReceive(String taskname, String taskdesc, String taskfor, String taskdate, String taskmember, String taskin) {
        this.taskname = taskname;
        this.taskdesc = taskdesc;
        this.taskfor = taskfor;
        this.taskdate = taskdate;
        this.taskmember = taskmember;
        this.taskin = taskin;
    }*/

/*    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("taskname", taskname);
        result.put("taskdesc", taskdesc);
        result.put("taskfor", taskfor);
        result.put("taskdate", taskdate);
        result.put("taskmember", taskmember);
        result.put("taskin", taskin);
        return result;
    }*/

}