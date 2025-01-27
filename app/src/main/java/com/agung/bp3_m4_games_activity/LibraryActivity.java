package com.agung.bp3_m4_games_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LibraryActivity extends AppCompatActivity {

    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_library);

        btnback = findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menangani klik pada gambar Dog
        ImageView dogImage = findViewById(R.id.dog);
        dogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, DetailActivity.class);
                intent.putExtra("animal_name", "Dog");
                startActivity(intent);
            }
        });

        // Menangani klik pada gambar Deer
        ImageView deerImage = findViewById(R.id.deer);
        deerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, DetailActivity2.class);
                intent.putExtra("animal_name", "Deer");
                startActivity(intent);
            }
        });

        // Menangani klik pada gambar Lion
        ImageView lionImage = findViewById(R.id.lion);
        lionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, DetailActivity3.class);
                intent.putExtra("animal_name", "Lion");
                startActivity(intent);
            }
        });

        // Menangani klik pada gambar Cat
        ImageView catImage = findViewById(R.id.cat);
        catImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, DetailActivity.class);
                intent.putExtra("animal_name", "Cat");
                startActivity(intent);
            }
        });

        // Tambahkan event klik untuk gambar lainnya sesuai kebutuhan
    }
}
