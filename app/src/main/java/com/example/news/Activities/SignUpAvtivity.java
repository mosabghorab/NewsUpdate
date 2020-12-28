package com.example.news.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.news.Models.Shared;
import com.example.news.Models.Signup.SignupTestInterface;
import com.example.news.Models.User;
import com.example.news.Presenters.SiginupActivityPresenter;
import com.example.news.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpAvtivity extends AppCompatActivity implements SignupTestInterface {


    private EditText name, email, password, confrimPassword;
    private Button signUpBtn;
    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    SiginupActivityPresenter siginupActivityPresenter;
    private CollectionReference collectionReferenceUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_avtivity);
        siginupActivityPresenter = new SiginupActivityPresenter(this);
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReferenceUsers = firebaseFirestore.collection("Users");
        name = findViewById(R.id.nameEdt);
        email = findViewById(R.id.emailEdt);
        password = findViewById(R.id.passwordEdt);
        confrimPassword = findViewById(R.id.passwordConfrimEdt);
        signUpBtn = findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siginupActivityPresenter.checkFromData(name.getText().toString(),email.getText().toString(),password.getText().toString(),confrimPassword.getText().toString() );


            }
        });


    }

    @Override
    public void sendRequestSignup() {
        final ProgressDialog progressDialog;
        if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty() && !confrimPassword.getText().toString().isEmpty()) {
            if (password.getText().toString().equals(confrimPassword.getText().toString())) {
                progressDialog = ProgressDialog.show(SignUpAvtivity.this, null, "Loading...");
                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpAvtivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if (authResult != null && authResult.getUser() != null) {
                            final User user = new User(authResult.getUser().getUid(), name.getText().toString(), email.getText().toString());
                            collectionReferenceUsers.document(authResult.getUser().getUid()).set(user).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.dismiss();
                                    Toast.makeText(SignUpAvtivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Shared.currentUser = user;
                                    Intent view = new Intent(SignUpAvtivity.this, MainActivity.class);
                                    view.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(view);
                                }
                            });
                        }
                    }
                });

            } else {
                Toast.makeText(SignUpAvtivity.this, "Password does not match", Toast.LENGTH_SHORT).show();

            }

        } else {
            Toast.makeText(SignUpAvtivity.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showErrorMessage() {

    }
}
