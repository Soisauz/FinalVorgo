package umn.ac.vorgoprojek.Feature_MyTask;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import umn.ac.vorgoprojek.R;

/**
 * Created by Avin on 08/08/2018.
 */

public class TaskReceiveHolder extends RecyclerView.ViewHolder {

    public TextView taskname;
    public TextView taskdesc;

    public TaskReceiveHolder(View itemView) {
        super(itemView);
        taskname = itemView.findViewById(R.id.taskname);
        taskdesc = itemView.findViewById(R.id.taskdesc);
    }

    public void bindToTask(TaskReceive task, View.OnClickListener onClickListener){
        taskname.setText(task.taskname);
        taskdesc.setText(task.taskdesc);
    }
}