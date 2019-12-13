package umn.ac.vorgoprojek.Feature_Project;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import umn.ac.vorgoprojek.R;

import static android.graphics.drawable.Drawable.createFromPath;

public class ProjectViewHolder extends RecyclerView.ViewHolder{

    public TextView edtTitle;
    public ImageView color;

    public ProjectViewHolder(View itemView) {
        super(itemView);
        edtTitle = itemView.findViewById(R.id.tv_edtTitle);
        color = itemView.findViewById(R.id.circle_project);
    }

    public void bindToProject(project project, View.OnClickListener onClickListener) {
        edtTitle.setText(project.edtTitle);
        if (project.color.equals("black")) color.setImageResource(R.drawable.circle_black);
        if (project.color.equals("purple")) color.setImageResource(R.drawable.circle_purple);
        if (project.color.equals("pink")) color.setImageResource(R.drawable.circle_pink);
        if (project.color.equals("yellow")) color.setImageResource(R.drawable.circle_yellow);
        if (project.color.equals("green")) color.setImageResource(R.drawable.circle_green);
    }
}