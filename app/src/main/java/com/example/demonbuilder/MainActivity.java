/**
 * @author Prince Sanchez
 * @since December 4, 2023
 * Description: Bodybuilding app!
 */
package com.example.demonbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the user is already logged in
        if (DemonBuilderPreferences.isLoggedIn(this)) {
            // User is logged in, navigate to LandingPage
            startActivity(new Intent(this, LandingPageActivity.class));
            finish(); // Close MainActivity to prevent going back to it with the back button
        }
        setContentView(R.layout.activity_main);

        // Get references to your buttons
        Button signUpButton = findViewById(R.id.button);
        Button loginButton = findViewById(R.id.button2);

        // Set click listener for the Sign Up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

        // Set click listener for the Log In button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

    }
}