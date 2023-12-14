package com.example.demonbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demonbuilder.DB.DemonBuilderDatabase;
import com.example.demonbuilder.DB.UserDAO;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Get references to your EditText widgets and the Sign Up button
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignUp = findViewById(R.id.buttonSignUp);

        // Set click listener for the Sign Up button
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the entered username and password
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Add your sign-up logic here
                // For now, we'll just show a Toast message with the entered data
                registerUser(username,password);
            }
        });
    }
    private void registerUser(String username, String password) {
        // Check if the username is available (you can add more validation logic)
        if (isUsernameAvailable(username)) {
            // Save the user in your data storage (e.g., SharedPreferences or a database)
            saveUser(username, password);

            // Set the user as logged in and navigate to LandingPageActivity
            DemonBuilderPreferences.setLoggedIn(this, true);
            startActivity(new Intent(this, LandingPageActivity.class));
            finish(); // Close SignUpActivity to prevent going back to it with the back button
        } else {
            // Handle username not available
            Toast.makeText(this, "Username already taken", Toast.LENGTH_SHORT).show();
        }
    }

    // Example method to check if the username is available
    private boolean isUsernameAvailable(String username) {
        // Add your logic to check if the username is available (e.g., against existing users)
        return !username.equals("testuser1") || !username.equals("admin2"); // Change this based on your validation logic
    }

    // Example method to save the user (you can store it in SharedPreferences or a database)
    private void saveUser(String username, String password) {
        User newUser = new User(username, password);

        // Insert user into the database
        // Assuming you have an instance of your database and UserDAO
        DemonBuilderDatabase db = DemonBuilderDatabase.getInstance(this);
        UserDAO userDAO = db.userDAO();
        userDAO.insert(newUser);
    }
}
