package com.agung.bp3_m4_games_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    Button playButton;
    Button libraryButton;
    Button laderboardButton;
    Button profileButton;  // Ini adalah tombol "Maker Application" di XML
    Button logoutButton;
    ImageView btnProfile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Inisialisasi tombol dan elemen UI
        playButton = findViewById(R.id.playButton);
        libraryButton = findViewById(R.id.libraryButton);
        laderboardButton = findViewById(R.id.laderboardButton);
        profileButton = findViewById(R.id.profileButton);  // Inisialisasi benar untuk Maker Application
        logoutButton = findViewById(R.id.logoutButton);
        btnProfile = findViewById(R.id.btnProfile);

        // Mengatur padding untuk sistem insets (Edge to Edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set event listener pada tombol
        playButton.setOnClickListener(v -> playGame());
        libraryButton.setOnClickListener(v -> pindahLibrary());
        laderboardButton.setOnClickListener(v -> pindahLaderboard());
        profileButton.setOnClickListener(v -> pindahProfile());  // Arahkan ke halaman ProfileActivity
        logoutButton.setOnClickListener(v -> pindahAwal());
        btnProfile.setOnClickListener(v -> pindahProfileEdit());
    }

    public void playGame() {
        Intent intent = new Intent(this, PlayGame.class);
        startActivity(intent);
    }

    public void pindahLibrary() {
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }

    public void pindahLaderboard() {
        Intent intent = new Intent(this, LaderboardActivity.class);
        startActivity(intent);
    }

    public void pindahProfile() {
        Intent intent = new Intent(this, ProfileActivity.class); // Pindah ke halaman ProfileActivity
        startActivity(intent);
    }

    public void pindahAwal() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void pindahProfileEdit() {
        Intent intent = new Intent(this, ProfileEdit.class);
        startActivity(intent);
    }
}
