package umn.ac.vorgoprojek.Feature_MyTask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import umn.ac.vorgoprojek.R;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_task);

        /*int getpos=0;

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            getpos = (int)bd.get("cardpos");
        }

        Toast.makeText(getApplicationContext(), getpos, Toast.LENGTH_LONG).show();*/

        Intent intent = getIntent();
        final String cardpos = String.valueOf(intent.getIntExtra("cardpos",0));
        //Toast.makeText(getApplicationContext(), cardpos, Toast.LENGTH_LONG).show();


    }

}
