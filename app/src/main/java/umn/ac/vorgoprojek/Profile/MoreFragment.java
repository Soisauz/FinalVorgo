package umn.ac.vorgoprojek.Profile;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import umn.ac.vorgoprojek.Feature_Project.add_project;
        import umn.ac.vorgoprojek.R;
        import umn.ac.vorgoprojek.Register_Login.User;

public class MoreFragment extends Fragment  {

    private Button btnSett;
    private TextView txtUsername, txtEmail;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private User user;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        txtUsername =(TextView)view.findViewById(R.id.txtUsername);
        txtEmail = (TextView)view.findViewById(R.id.txtEmail);


        String uid = auth.getInstance().getCurrentUser().getUid();

        db.getInstance().getReference().child("user").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    User user = dataSnapshot.getValue(User.class);

                    String email=user.getEmail();
                    txtEmail.setText(email);

                    String username =user.getUsername();
                    txtUsername.setText(username);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });


        btnSett =(Button)view.findViewById(R.id.btnSetting);
        btnSett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment childFragment = new setting();
                FragmentTransaction trans = getChildFragmentManager().beginTransaction();
                trans.replace(R.id.fl_container, childFragment).commit();
            }
        });
        return view;
    }
}
