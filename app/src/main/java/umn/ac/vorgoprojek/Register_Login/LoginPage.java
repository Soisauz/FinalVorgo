package umn.ac.vorgoprojek.Register_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import umn.ac.vorgoprojek.BottomNav;
import umn.ac.vorgoprojek.Feature_MyTask.Mytask_actv;

import umn.ac.vorgoprojek.R;



public class LoginPage extends AppCompatActivity {

    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BottomNav.class);
                startActivity(i);
            }
        });
    }
}
