package umn.ac.vorgoprojek.Feature_MyTask;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        fab = getView().findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(v.this, "Clicked the FAB!",Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false);
    }

}
