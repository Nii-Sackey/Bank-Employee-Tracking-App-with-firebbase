
package com.example.employee_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
     TextView Alreadyregistered;
     EditText fullname,SignUpEmail,phoneNumber,SignUpPassword;
    Button Register;
    FirebaseAuth fauth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //user already registered
        if (fauth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        Alreadyregistered = findViewById(R.id.up);
        fullname = findViewById(R.id.fullname);
        SignUpEmail = findViewById(R.id.SignUpEmail);
        phoneNumber= findViewById(R.id.phoneNumber);
        SignUpPassword = findViewById(R.id.SignUpPassword);
        Register = findViewById(R.id.register);
        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = SignUpEmail.getText().toString().trim();
                String password = SignUpPassword.getText().toString().trim();
                final String fullName = fullname.getText().toString();
                String PhoneNumber = phoneNumber.getText().toString();

                if (TextUtils.isEmpty(email)){
                    SignUpEmail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    SignUpPassword.setError("Password is Required");
                    return;
                }
                if (password.length()<6){
                    SignUpPassword.setError("Password must be more than 6 characters");
                    return;
                }

                //Register the user using firebase.
                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_SHORT).show();
                            userID = fauth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object>user = new HashMap<>();
                            user.put("fName",fullname);
                            user.put("email",SignUpEmail);
                            user.put("phone",phoneNumber);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "onSuccess: user Profile is created for " + userID);


                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(SignUp.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}