package umn.ac.vorgoprojek.Feature_MyTask;

public class item_task {
    String taskName;
    String DueDate;
    String taskImage;

    public item_task(){

    }

    public item_task(String taskName, String dueDate, String taskImage) {
        this.taskName = taskName;
        this.DueDate = dueDate;
        this.taskImage = taskImage;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(String taskImage) {
        this.taskImage = taskImage;
    }
}
