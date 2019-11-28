package umn.ac.vorgoprojek.Feature_MyTask;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import umn.ac.vorgoprojek.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class daily extends Fragment {


    public daily() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false);
    }

}
