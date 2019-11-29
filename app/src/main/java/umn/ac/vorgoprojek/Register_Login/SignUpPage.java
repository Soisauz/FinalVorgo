package umn.ac.vorgoprojek.Register_Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import umn.ac.vorgoprojek.MainActivity;
import umn.ac.vorgoprojek.R;

public class SignUpPage extends AppCompatActivity {
    private TextView txtSignIn;

    private Button btnSignUp;
    private FirebaseAuth auth;
    private EditText edtUser, edtEmail, edtPass;
    FirebaseDatabase database;
    DatabaseReference reff;
    User user;
    
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



        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtUser = (EditText)findViewById(R.id.edtUserName);
        database = FirebaseDatabase.getInstance();
        reff = database.getReference("user");
        user = new User();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtEmail.getText().toString().trim();
                final String pass = edtPass.getText().toString().trim();
                final String username = edtUser.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() < 6 ){
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(SignUpPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUpPage.this, "createUserWithEmail:onComplete" +task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                if (!task.isSuccessful()){
                                    Toast.makeText(SignUpPage.this, "Authentication failed" +task.getException(), Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(SignUpPage.this, MainActivity.class));
                                }
                            }
                        });


            }


        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
