package umn.ac.vorgoprojek.Register_Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import umn.ac.vorgoprojek.Feature_Project.Project;
import umn.ac.vorgoprojek.MainActivity;
import umn.ac.vorgoprojek.R;



public class LoginPage extends AppCompatActivity {

    private Button btnSignIn;
    private EditText edtEmail, edtPass;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() !=null){
            startActivity(new Intent(LoginPage.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login_page);

        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPass = (EditText)findViewById(R.id.edtPass);


        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        auth = FirebaseAuth.getInstance();


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                final String pass = edtPass.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    if (pass.length()<6){
                                        edtPass.setError(getString(R.string.min_pass));
                                    } else {
                                        Toast.makeText(LoginPage.this, "Authentication Failed", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent i = new Intent(LoginPage.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }
                        });

            }
        });


    }
}
