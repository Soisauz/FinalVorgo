package umn.ac.vorgoprojek.Feature_MyTask;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Avin on 08/08/2018.
 */

public class TaskReceive {
    public String taskname;
    public String taskdesc;

    public TaskReceive() {
    }

    public TaskReceive(String taskname, String taskdesc) {
        this.taskname = taskname;
        this.taskdesc = taskdesc;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("taskname", taskname);
        result.put("taskdesc", taskdesc);
        return result;
    }

}