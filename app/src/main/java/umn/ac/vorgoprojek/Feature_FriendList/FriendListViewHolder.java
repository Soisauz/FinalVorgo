package umn.ac.vorgoprojek.Feature_FriendList;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import umn.ac.vorgoprojek.R;

public class FriendListViewHolder extends RecyclerView.ViewHolder{

    public TextView email;
    public TextView username;
    public ImageView ProfilePic;
    public FriendListViewHolder(View itemView) {
        super(itemView);
        email = itemView.findViewById(R.id.emailUser);
        username = itemView.findViewById(R.id.namaUser);
        ProfilePic = itemView.findViewById(R.id.ProfPic);
    }

    public void bindToFriendList(FriendList fl, View.OnClickListener onClickListener){
        email.setText(fl.email);
        username.setText(fl.username);
    }
}
