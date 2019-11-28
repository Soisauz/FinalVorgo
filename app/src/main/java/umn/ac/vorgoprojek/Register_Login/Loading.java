package umn.ac.vorgoprojek.Register_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import umn.ac.vorgoprojek.MainActivity;
import umn.ac.vorgoprojek.R;
public class Loading extends AppCompatActivity {

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    auth = FirebaseAuth.getInstance();

                    if (auth.getCurrentUser() !=null){
                        startActivity(new Intent(Loading.this, MainActivity.class));
                        finish();
                    } else {
                        Intent i = new Intent(Loading.this, welcomePage.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        };
        welcomeThread.start();
    }
}
