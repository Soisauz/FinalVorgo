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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import umn.ac.vorgoprojek.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_project extends Fragment {

    EditText edtTitle;
    Button purple, pink, green, black, yellow;
    DatabaseReference reff;
    long maxid = 0;

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

        edtTitle = (EditText)view.findViewById(R.id.edtTitle);
        purple = (Button)view.findViewById(R.id.btnPurple);
        pink = (Button)view.findViewById(R.id.btnPink);
        green = (Button)view.findViewById(R.id.btnGreen);
        black = (Button)view.findViewById(R.id.btnBlack);
        yellow = (Button)view.findViewById(R.id.btnYellow);

        reff = FirebaseDatabase.getInstance().getReference().child("Project");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        final project project = new project();

        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                project.setEdtTitle(edtTitle.getText().toString().trim());
                project.setColor("purple");
                reff.child(String.valueOf(maxid+1)).setValue(project);
                getFragmentManager().beginTransaction().remove(add_project.this).commit();
            }
        });

        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                project.setEdtTitle(edtTitle.getText().toString().trim());
                project.setColor("pink");
                reff.child(String.valueOf(maxid+1)).setValue(project);
                getFragmentManager().beginTransaction().remove(add_project.this).commit();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                project.setEdtTitle(edtTitle.getText().toString().trim());
                project.setColor("green");
                reff.child(String.valueOf(maxid+1)).setValue(project);
                getFragmentManager().beginTransaction().remove(add_project.this).commit();
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                project.setEdtTitle(edtTitle.getText().toString().trim());
                project.setColor("black");
                reff.child(String.valueOf(maxid+1)).setValue(project);
                getFragmentManager().beginTransaction().remove(add_project.this).commit();
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                project.setEdtTitle(edtTitle.getText().toString().trim());
                project.setColor("yellow");
                reff.child(String.valueOf(maxid+1)).setValue(project);
                getFragmentManager().beginTransaction().remove(add_project.this).commit();
            }
        });
        return view;

    }




}
