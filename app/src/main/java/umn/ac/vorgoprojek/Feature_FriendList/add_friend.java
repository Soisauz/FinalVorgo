package umn.ac.vorgoprojek.Feature_FriendList;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import umn.ac.vorgoprojek.Feature_Project.add_project;
import umn.ac.vorgoprojek.R;
import umn.ac.vorgoprojek.Register_Login.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_friend extends Fragment {


    public add_friend() {
        // Required empty public constructor
    }

    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private User user;
    private EditText edtEmail;
    private Button btnAddFriend;
    private FriendList FL;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_friend, container, false);
        TextView txtClose = (TextView)view.findViewById(R.id.txtClose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(add_friend.this).commit();
            }
        });

        edtEmail = (EditText)view.findViewById(R.id.edtEmailFriend);


        btnAddFriend = (Button)view.findViewById(R.id.btnAddFriend);
        FL = new FriendList();

        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtEmail.getText().toString();
                //Toast.makeText(getActivity(), "email"+email, Toast.LENGTH_LONG).show();
                db.getInstance().getReference().child("user").orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){

                            for (DataSnapshot child : dataSnapshot.getChildren()) {
                                // do something with the individual "issues"
                                final String key = child.getKey();
                                final String username = child.child("username").getValue().toString();

                                db.getInstance().getReference().child("friend").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                        db.getInstance().getReference().child("friend").child(UID).child(key).child("username").setValue(username);
                                        db.getInstance().getReference().child("friend").child(UID).child(key).child("email").setValue(email);
                                        db.getInstance().getReference().child("friend").child(UID).child(key).child("friend").setValue("true");
                                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });

                            }

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        throw databaseError.toException();
                    }
                });

            }
        });


        return view;
    }





}
