package umn.ac.vorgoprojek.Feature_Project;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import umn.ac.vorgoprojek.R;

public class ProjectFragment extends Fragment {



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
        return view;
    }






}
