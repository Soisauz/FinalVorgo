package umn.ac.vorgoprojek.Feature_Project;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.larapin.akospin.R;

public class ProjectViewHolder extends RecyclerView.ViewHolder{

    public TextView edtTitle;

    public ProjectViewHolder(View itemView) {
        super(itemView);
        edtTitle = itemView.findViewById(R.id.tv_edtTitle);
    }

    public void bindToProject(Project project, View.OnClickListener onClickListener){
        edtTitle.setText(project.edtTitle);
    }
}