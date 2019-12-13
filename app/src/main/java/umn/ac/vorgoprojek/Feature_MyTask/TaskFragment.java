package umn.ac.vorgoprojek.Feature_MyTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import umn.ac.vorgoprojek.Feature_MyTask.TabAdapter;
import umn.ac.vorgoprojek.Feature_MyTask.daily;
import umn.ac.vorgoprojek.Feature_MyTask.month;
import umn.ac.vorgoprojek.R;

public class TaskFragment extends Fragment {
    DatabaseReference reff;
    RecyclerView ourdoes;
    ArrayList<item_task> list;
    //TaskAdapter taskAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

/*
        ourdoes = view.findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        list = new ArrayList<item_task>();

        //get data
        reff = FirebaseDatabase.getInstance().getReference().child("Task");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //set code to retrieve
*/
/*                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    item_task p = dataSnapshot1.getValue(item_task.class);
                    list.add(p);
                }
                ourdoes = new TaskAdapter(TaskFragment.this, list);
                *//*


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "No data", Toast.LENGTH_SHORT).show();
            }
        });
*/

        return view;


    }

    private void setupViewPager(ViewPager viewPager){
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new daily(), "Daily");
        tabAdapter.addFragment(new month(), "Month");
        viewPager.setAdapter(tabAdapter);
    }




}
