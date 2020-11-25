package com.dundyne.androidworkout;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
         FirebaseAuth auth;
        FirebaseAuth.AuthStateListener authStateListener;

        private final int RC_SIGN_IN = 1;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);


        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = auth.getCurrentUser();
                if(currentUser == null) {

                    // Choose authentication providers
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.GoogleBuilder().build());


// Create and launch sign-in intent
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);


                }

                else {
                    Toast.makeText(getApplicationContext(), "Signed in as " + currentUser.getDisplayName(), Toast.LENGTH_LONG).show();
                }
        }


            };

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN)
                return;

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser currentUser = auth.getCurrentUser();
                Toast.makeText(getApplicationContext(), "Signed in as " + currentUser, Toast.LENGTH_LONG).show();
                // ...
            } else {
                Toast.makeText(getApplicationContext(), "Not signed in", Toast.LENGTH_LONG).show();
            }
        }



    @Override
    protected void onResume() {
        super.onResume();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        auth.removeAuthStateListener(authStateListener);
    }
}
