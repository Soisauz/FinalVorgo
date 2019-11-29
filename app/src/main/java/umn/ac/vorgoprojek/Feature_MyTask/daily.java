package umn.ac.vorgoprojek.Feature_MyTask;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import umn.ac.vorgoprojek.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class daily extends Fragment {

    FloatingActionButton fab;



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
        return v;
    }

}
