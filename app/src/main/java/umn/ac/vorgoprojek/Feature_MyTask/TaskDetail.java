package umn.ac.vorgoprojek.Feature_MyTask;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import umn.ac.vorgoprojek.R;

public class TaskDetail extends AppCompatActivity {

    FirebaseDatabase db;
    //private FirebaseRecyclerAdapter<TaskDetailReceive, TaskDetailReceiveHolder> mAdapter;
    private TextView txttaskname, txttaskfor, txttaskdate, txttaskdesc, txttaskmember, txttaskin;
    private TaskDetailReceive tdr;

    public TaskDetail() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_task);

        Intent intent = getIntent();
        final String cardpos = String.valueOf(intent.getIntExtra("cardpos",0));
        //Toast.makeText(getApplicationContext(), cardpos, Toast.LENGTH_LONG).show();

        txttaskname = findViewById(R.id.taskname);
        txttaskfor = findViewById(R.id.taskfor);
        txttaskdate = findViewById(R.id.taskdate);
        txttaskdesc = findViewById(R.id.taskdesc);
        txttaskmember = findViewById(R.id.taskmember);
        txttaskin = findViewById(R.id.taskin);

        db.getInstance().getReference().child("Task").child(cardpos).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    TaskDetailReceive tdr = dataSnapshot.getValue(TaskDetailReceive.class);

                    String taskname = tdr.getTaskname();
                    String taskfor = tdr.getTaskfor();
                    String taskdate = tdr.getTaskdate();
                    String taskdesc = tdr.getTaskdesc();
                    String taskmember = tdr.getTaskmember();
                    String taskin = tdr.getTaskin();

                    txttaskname.setText(taskname);
                    txttaskfor.setText(taskfor);
                    txttaskdate.setText(taskdate);
                    txttaskdesc.setText(taskdesc);
                    txttaskmember.setText(taskmember);
                    txttaskin.setText(taskin);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

    }

}
