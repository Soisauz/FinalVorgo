package umn.ac.vorgoprojek.Feature_Project;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import umn.ac.vorgoprojek.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_project extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.project_dialog, container, false);

        TextView txtClose = (TextView)view.findViewById(R.id.txtClose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(add_project.this).commit();
            }
        });
        return view;

    }




}
