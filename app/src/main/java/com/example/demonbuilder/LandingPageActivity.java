package com.example.demonbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        TextView textViewUsername = findViewById(R.id.textViewUsername);
        TextView textViewAdminStatus = findViewById(R.id.textViewAdminStatus);
        Button btnAdminArea = findViewById(R.id.btnAdminArea);
        Button btnLogout = findViewById(R.id.btnLogout);

        // Retrieve user information from SharedPreferences or user table
        String username = DemonBuilderPreferences.getmUsername(this);
        Log.d("LandingPageActivity", "Retrieved username: " + username);
        boolean isAdmin = DemonBuilderPreferences.isAdmin(this);

        // Update UI with user information
        textViewUsername.setText("Username: " + username);
        textViewAdminStatus.setText("Admin: " + (isAdmin ? "Yes" : "No"));

        // Show/hide admin area button based on admin status
        btnAdminArea.setVisibility(isAdmin ? View.VISIBLE : View.INVISIBLE);

        // Set click listener for admin area button
        btnAdminArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle admin area button click
                // Implement the logic to navigate to the admin area
            }
        });

        // Set click listener for logout button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle logout button click
                // Reset SharedPreferences and start MainActivity
                DemonBuilderPreferences.setLoggedIn(LandingPageActivity.this, false);
                startActivity(new Intent(LandingPageActivity.this, MainActivity.class));
                finish();  // Close LandingPageActivity
            }
        });
    }
}
