package umn.ac.vorgoprojek.Feature_FriendList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import umn.ac.vorgoprojek.Feature_Project.add_project;
import umn.ac.vorgoprojek.R;

public class FriendFragment extends Fragment {

    private RecyclerView mFriendList;
    private DatabaseReference reff;
    private LinearLayoutManager mManager;
    private FirebaseRecyclerAdapter<FriendList, FriendListViewHolder> mAdapter;

    public FriendFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        FloatingActionButton fabProject =(FloatingActionButton)view.findViewById(R.id.fabAddFriend);
        fabProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment childFragment = new add_friend();
                FragmentTransaction trans = getChildFragmentManager().beginTransaction();
                trans.replace(R.id.fl_container, childFragment).commit();
            }
        });


        reff= FirebaseDatabase.getInstance().getReference();

        mFriendList = (RecyclerView)view.findViewById(R.id.RVFriend);
        mFriendList.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getContext());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mFriendList.setLayoutManager(mManager);

        Query query = getQuery(reff);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<FriendList>()
                .setQuery(query, FriendList.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<FriendList, FriendListViewHolder>(options) {
            @Override
            public FriendListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new FriendListViewHolder(inflater.inflate(R.layout.friend_row, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull FriendListViewHolder friendListViewHolder, int i, @NonNull final FriendList model) {
                friendListViewHolder.bindToFriendList(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();
        mFriendList.setAdapter(mAdapter);




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null){
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null){
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference reff){
        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = reff.child("friend").child(UID);
        return query;
    }
}
