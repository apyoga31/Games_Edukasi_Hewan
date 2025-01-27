package com.agung.bp3_m4_games_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginButton);

        // Handle Edge-to-Edge UI Padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginButton.setOnClickListener(v -> pindahHome());

        // Logic for AutoCompleteTextView
        setupAutoComplete();
    }

    public void pindahHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void setupAutoComplete() {
        // Sample data for AutoComplete suggestions
        String[] usernames = {"Agung", "Abdul", "Budi", "Bulma", "Cecep", "Cadut"};

        // Initialize ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                usernames
        );

        // Find AutoCompleteTextView by ID
        AutoCompleteTextView usernameAutoComplete = findViewById(R.id.usernameAutoComplete);

        // Set adapter to AutoCompleteTextView
        usernameAutoComplete.setAdapter(adapter);

        // Optional: Set a threshold (minimum characters to trigger suggestions)
        usernameAutoComplete.setThreshold(1);
    }
}
