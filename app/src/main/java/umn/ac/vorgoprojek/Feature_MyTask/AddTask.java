package umn.ac.vorgoprojek.Feature_MyTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import umn.ac.vorgoprojek.R;

public class AddTask extends AppCompatActivity {

    String currUser;
    EditText edtFor, edtIn, edtTaskName, edtDesc, edtDate, edtMember;
    Button btnAddTask;
    DatabaseReference reff;
    Task task;
    long maxid=0;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        edtFor = (EditText)findViewById(R.id.edtFor);
        edtIn = (EditText)findViewById(R.id.edtIn);
        edtTaskName = (EditText)findViewById(R.id.edtTaskName);
        edtDesc = (EditText)findViewById(R.id.edtDesc);
        edtDate = (EditText)findViewById(R.id.edtDate);
        currUser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();;
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(AddTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edtDate.setText(i2 +"/"+(i1+1)+"/"+i);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        edtMember = (EditText)findViewById(R.id.edtMember);
        btnAddTask = (Button)findViewById(R.id.btnAddTask);
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
                //String stringdate = dt.format(edtDate);

                task.setCurrUser(currUser.trim());
                task.setEdtFor(edtFor.getText().toString().trim());
                task.setEdtIn(edtIn.getText().toString().trim());
                task.setEdtTaskName(edtTaskName.getText().toString().trim());
                task.setEdtDesc(edtDesc.getText().toString().trim());
                task.setEdtMember(edtMember.getText().toString().trim());
                task.setEdtDate(edtDate.getText().toString().trim());

                reff.child(String.valueOf(maxid+1)).setValue(task);

                Toast.makeText(AddTask.this, "Success!!",Toast.LENGTH_LONG).show();
                getFragmentManager().beginTransaction().remove(AddTask.this).commit();

            }
        });
    }
}
