package umn.ac.vorgoprojek.Feature_MyTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.api.DistributionOrBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.microedition.khronos.egl.EGLDisplay;

import umn.ac.vorgoprojek.Feature_Project.add_project;
import umn.ac.vorgoprojek.Profile.MoreFragment;
import umn.ac.vorgoprojek.R;

public class AddTask extends AppCompatActivity {

    String currUser;
    EditText taskname, taskdesc, taskdate;
    AutoCompleteTextView taskfor, taskin, taskmember;
    Button btnAddTask;
    DatabaseReference reff, reff2, reff3, reff4;
    Task task;
    long maxid=0;
    DatePickerDialog datePickerDialog;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        taskfor = (AutoCompleteTextView) findViewById(R.id.edtFor);
        taskin = (AutoCompleteTextView) findViewById(R.id.edtIn);
        taskname = (EditText)findViewById(R.id.edtTaskName);
        taskdesc = (EditText)findViewById(R.id.edtDesc);
        taskdate = (EditText)findViewById(R.id.edtDate);
        currUser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        taskdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();;
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(AddTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        taskdate.setText(i2 +"/"+(i1+1)+"/"+i);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        taskmember = (AutoCompleteTextView) findViewById(R.id.edtMember);
        btnAddTask = (Button)findViewById(R.id.btnAddTask);

        reff2 = FirebaseDatabase.getInstance().getReference().child("user");

        final ArrayAdapter<String> autoComplete = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1);
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                    String suggestion = suggestionSnapshot.child("username").getValue(String.class);
                    autoComplete.add(suggestion);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        taskfor.setThreshold(1);
        taskfor.setAdapter(autoComplete);

        reff3 = FirebaseDatabase.getInstance().getReference().child("Project");

        final ArrayAdapter<String> autoComplete2 = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1);
        reff3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                    String suggestion2 = suggestionSnapshot.child("edtTitle").getValue(String.class);
                    autoComplete2.add(suggestion2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        taskin.setThreshold(1);
        taskin.setAdapter(autoComplete2);

        reff4 = FirebaseDatabase.getInstance().getReference().child("user");

        final ArrayAdapter<String> autoComplete3 = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1);
        reff4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                    String suggestion3 = suggestionSnapshot.child("username").getValue(String.class);
                    autoComplete3.add(suggestion3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        taskmember.setThreshold(1);
        taskmember.setAdapter(autoComplete3);

        task = new Task();
        reff = FirebaseDatabase.getInstance().getReference().child("Task");

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



        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");


                task.setCurrUser(currUser.trim());
                task.setTaskfor(taskfor.getText().toString().trim());
                task.setTaskin(taskin.getText().toString().trim());
                task.setTaskname(taskname.getText().toString().trim());
                task.setTaskdesc(taskdesc.getText().toString().trim());
                task.setTaskmember(taskmember.getText().toString().trim());
                task.setTaskdate(taskdate.getText().toString().trim());
                task.setStatus("uncompleted");

                reff.child(String.valueOf(maxid+1)).setValue(task);

                //Toast.makeText(AddTask.this, "Success!!",Toast.LENGTH_LONG).show();
                finishAndRemoveTask();


            }
        });
    }
}
