package umn.ac.vorgoprojek.Feature_MyTask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import umn.ac.vorgoprojek.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context context;
    ArrayList<item_task> Item_task;
    public TaskAdapter(Context c, ArrayList<item_task> p){
        context =c;
        Item_task =p;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder((LayoutInflater.from(context).inflate(R.layout.project_row, parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.taskName.setText(Item_task.get(position).getTaskName());
        myViewHolder.DueDate.setText(Item_task.get(position).getDueDate());
        myViewHolder.taskImage.setText(Item_task.get(position).getTaskImage());

        final String getTaskName = Item_task.get(position).getTaskName();
        final String getDueDate = Item_task.get(position).getDueDate();
        final String getTaskImage = Item_task.get(position).getTaskImage();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return Item_task.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView taskName, DueDate, taskImage;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            taskName =(TextView)itemView.findViewById(R.id.project_name);
            DueDate = (TextView)itemView.findViewById(R.id.ProjectTask);
            taskImage = (TextView)itemView.findViewById(R.id.task_image);
        }
    }
}
