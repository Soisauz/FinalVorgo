package umn.ac.vorgoprojek.Feature_Project;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import umn.ac.vorgoprojek.Feature_FriendList.FriendList;
import umn.ac.vorgoprojek.Feature_FriendList.FriendListViewHolder;
import umn.ac.vorgoprojek.Feature_MyTask.RecycleViewClickListener;
import umn.ac.vorgoprojek.Feature_MyTask.TaskDetail;
import umn.ac.vorgoprojek.R;

public class ProjectFragment extends Fragment {

    private RecyclerView mProjectList;
    private DatabaseReference reff;
    private LinearLayoutManager mManager;
    private FirebaseRecyclerAdapter<project, ProjectViewHolder> mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_project, container, false);
        FloatingActionButton fabProject =(FloatingActionButton)view.findViewById(R.id.fabProject);
        fabProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment childFragment = new add_project();
                FragmentTransaction trans = getChildFragmentManager().beginTransaction();
                trans.replace(R.id.fl_container, childFragment).commit();
            }
        });

        reff= FirebaseDatabase.getInstance().getReference();

        mProjectList = (RecyclerView)view.findViewById(R.id.RVProject);
        mProjectList.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getContext());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mProjectList.setLayoutManager(mManager);

        Query query = getQuery(reff);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<project>()
                .setQuery(query, project.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<project, ProjectViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProjectViewHolder projectViewHolder, int i, @NonNull final project project) {
                projectViewHolder.bindToProject(project, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
            }

            @Override
            public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new ProjectViewHolder(inflater.inflate(R.layout.project_row, parent, false));
            }
        };

        mProjectList.addOnItemTouchListener(new RecycleViewClickListener(getContext(), mProjectList, new RecycleViewClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "Cardview ke - " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), subproject.class);
                intent.putExtra("cardpos", position);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        mAdapter.notifyDataSetChanged();
        mProjectList.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null){
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null){
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference reff){
        //String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = reff.child("Project");
        return query;
    }






}
