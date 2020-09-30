package umn.ac.vorgoprojek.Feature_Project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import umn.ac.vorgoprojek.Feature_MyTask.AddTask;
import umn.ac.vorgoprojek.Feature_MyTask.RecycleViewClickListener;
import umn.ac.vorgoprojek.Feature_MyTask.TaskDetail;
import umn.ac.vorgoprojek.Feature_MyTask.TaskDetailReceive;
import umn.ac.vorgoprojek.Feature_MyTask.TaskReceive;
import umn.ac.vorgoprojek.Feature_MyTask.TaskReceiveHolder;
import umn.ac.vorgoprojek.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class subproject extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference reff;
    FloatingActionButton fab;
    private FirebaseRecyclerAdapter<TaskReceive, TaskReceiveHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    public String edtTitletemp;

    public subproject() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        //final View v = inflater.inflate(R.layout.fragment_daily, container, false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_projek);
        reff = FirebaseDatabase.getInstance().getReference();

        mRecycler = findViewById(R.id.subtask);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getApplicationContext());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        Query query = getQuery(reff);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<TaskReceive>()
                .setQuery(query, TaskReceive.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<TaskReceive, TaskReceiveHolder>(options) {
            @Override
            public TaskReceiveHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new TaskReceiveHolder(inflater.inflate(R.layout.task_row, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull TaskReceiveHolder holder, final int position, @NonNull final TaskReceive model) {
                holder.bindToTask(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };

        Intent intent = getIntent();
        String cardpos = String.valueOf(intent.getIntExtra("cardpos",1));

        db.getInstance().getReference().child("Project").child(cardpos).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    final project tdr = dataSnapshot.getValue(project.class);
                    final String edtTitle = tdr.getEdtTitle();
                    edtTitletemp = edtTitle;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        mRecycler.addOnItemTouchListener(new RecycleViewClickListener(getApplicationContext(), mRecycler, new RecycleViewClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getContext(), "Cardview ke - " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), TaskDetail.class);
                intent.putExtra("cardpos", position);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference reff) {
        Query query = reff.child("Task").orderByChild("taskin").startAt(edtTitletemp).endAt(edtTitletemp);
        return query;
    }








}
