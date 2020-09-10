package com.example.firebasephonenumberauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.login);
        btnLogout = findViewById(R.id.logout);
        btnLogin.setOnClickListener(this);
        btnLogout.setOnClickListener(this);


        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            btnLogout.setVisibility(View.GONE);


        } else {
            btnLogin.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            startActivity(new Intent(getApplicationContext(), Phone_Auth.class));
        } else if (view == btnLogout) {
            FirebaseAuth.getInstance().signOut();
            recreate();
        }
    }
}