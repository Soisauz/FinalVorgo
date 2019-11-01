package umn.ac.vorgoprojek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.view.View.OnClickListener;


public class Projek extends AppCompatActivity {

    ActivityFabBinding b1;
    boolean isRotate = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projek);
        
        b1 = DataBindingUtil.setContentView(this, R.layout.activity_projek);
        
        b1.fabAdd.setOnClickListener(new OnClickListener(){
            @Override
            onClick
        })
    }
}
