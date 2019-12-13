package umn.ac.vorgoprojek.Feature_MyTask;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

import umn.ac.vorgoprojek.R;

public class TaskDetail extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference reff;
    private TextView txttaskname, txttaskfor, txttaskdate, txttaskdesc, txttaskmember, txttaskin;
    private String tskname, tskfor, tskdate, tskdesc, tskmember, tskin;
    private TaskDetailReceive tdr;

    public TaskDetail() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_task);

        Intent intent = getIntent();
        String cardpos = String.valueOf(intent.getIntExtra("cardpos",1));
        int tempcardpos = Integer.parseInt(cardpos);
        if (tempcardpos == 0) {
            cardpos = "1";
        }
        final String cardposs = cardpos;
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
                    final TaskDetailReceive tdr = dataSnapshot.getValue(TaskDetailReceive.class);

                    final String taskname = tdr.getTaskname();
                    final String taskfor = tdr.getTaskfor();
                    final String taskdate = tdr.getTaskdate();
                    final String taskdesc = tdr.getTaskdesc();
                    final String taskmember = tdr.getTaskmember();
                    final String taskin = tdr.getTaskin();

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

        reff = FirebaseDatabase.getInstance().getReference().child("Task").child(cardpos);

        Button btnComplete = findViewById(R.id.btnComplete);

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Map<String, Object> stat = new HashMap<>();
                stat.put("status","completed");
                reff.updateChildren(stat);
                finishAndRemoveTask();*/
                reff.removeValue();
                finishAndRemoveTask();
            }
        });

        TextView txtclose = findViewById(R.id.txtClose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }



}
