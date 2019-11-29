package umn.ac.vorgoprojek.Profile;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import umn.ac.vorgoprojek.Feature_Project.add_project;
import umn.ac.vorgoprojek.R;
import umn.ac.vorgoprojek.Register_Login.welcomePage;

/**
 * A simple {@link Fragment} subclass.
 */
public class setting extends Fragment {


    public setting() {
        // Required empty public constructor
    }

    private Button btnLogOut, btnChangePass, btnChangeEmail;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        TextView txtClose = (TextView)v.findViewById(R.id.txtClose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(setting.this).commit();
            }
        });

        auth = FirebaseAuth.getInstance();
        btnLogOut=(Button)v.findViewById(R.id.btnLogOut);
        btnChangeEmail =(Button)v.findViewById(R.id.btnChangeEmail);
        btnChangePass = (Button)v.findViewById(R.id.btnChangePass);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                getActivity().finish();
                Intent intent = new Intent(getActivity(), welcomePage.class);
                startActivity(intent);
            }
        });


        return v;
    }

}
