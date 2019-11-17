package umn.ac.vorgoprojek.Register_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import umn.ac.vorgoprojek.R;

public class SignUpPage extends AppCompatActivity {
    private TextView txtSignIn;

    private Button btnSignUp;

    private EditText edtUser, edtEmail, edtPass;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        txtSignIn = (TextView)findViewById(R.id.txtSignIn);
        txtSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        });
    }
}
