package umn.ac.vorgoprojek.Feature_MyTask;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import umn.ac.vorgoprojek.MainActivity;
import umn.ac.vorgoprojek.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class daily extends Fragment {

    FirebaseDatabase db;
    DatabaseReference reff;
    FloatingActionButton fab;
    private FirebaseRecyclerAdapter<TaskReceive, TaskReceiveHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    public daily() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //final View v = inflater.inflate(R.layout.fragment_daily, container, false);
        View v = inflater.inflate(R.layout.fragment_daily, container, false);
        FloatingActionButton fabAddTask = (FloatingActionButton)v.findViewById(R.id.fabAddTask);
        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddTask.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });

        reff = FirebaseDatabase.getInstance().getReference();

        mRecycler = v.findViewById(R.id.tasklist);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getContext());
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


        mRecycler.addOnItemTouchListener(new RecycleViewClickListener(getContext(), mRecycler, new RecycleViewClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getContext(), "Cardview ke - " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), TaskDetail.class);
                intent.putExtra("cardpos", position);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);


        return v;
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
        Query query = reff.child("Task");
        return query;
    }








}
