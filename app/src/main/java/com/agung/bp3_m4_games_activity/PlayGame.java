package com.agung.bp3_m4_games_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayGame extends AppCompatActivity {  // Kelas dimulai di sini
    ImageButton btnBack;
    private TextView answerText;
    private String currentAnswer = "";
    private final String correctAnswer = "LION";
    private Button btnReset, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game); // Pastikan nama layout sesuai

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayGame.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Inisialisasi views
        answerText = findViewById(R.id.answerText);
        btnReset = findViewById(R.id.btn_reset);
        btnSubmit = findViewById(R.id.btn_submit);

        Button letterO = findViewById(R.id.letterO);
        Button letterI = findViewById(R.id.letterI);
        Button letterL = findViewById(R.id.letterL);
        Button letterN = findViewById(R.id.letterN);

        // Set button click listeners
        letterO.setOnClickListener(new LetterClickListener("O"));
        letterI.setOnClickListener(new LetterClickListener("I"));
        letterL.setOnClickListener(new LetterClickListener("L"));
        letterN.setOnClickListener(new LetterClickListener("N"));

        // Set Reset button listener
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        // Set Submit button listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAnswer();
            }
        });

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Custom OnClickListener for letter buttons
    private class LetterClickListener implements View.OnClickListener {
        private final String letter;

        public LetterClickListener(String letter) {
            this.letter = letter;
        }

        @Override
        public void onClick(View v) {
            if (currentAnswer.length() < correctAnswer.length()) {
                currentAnswer += letter;
                answerText.setText(currentAnswer);

                // Check if the current answer matches the correct answer
                if (currentAnswer.equals(correctAnswer)) {
                    Toast.makeText(PlayGame.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(PlayGame.this, "You've entered all letters!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Reset the game
    private void resetGame() {
        currentAnswer = "";
        answerText.setText(currentAnswer);
        Toast.makeText(this, "Game Reset", Toast.LENGTH_SHORT).show();
    }

    // Submit the answer
    private void submitAnswer() {
        if (currentAnswer.equals(correctAnswer)) {
            Toast.makeText(this, "Congratulations! Correct Answer!", Toast.LENGTH_SHORT).show();

            // Arahkan ke activity lain, misalnya level berikutnya
            Intent intent = new Intent(PlayGame.this, LaderboardActivity.class); // Ganti dengan nama activity tujuan
            startActivity(intent);
            finish(); // Tutup activity saat ini
        } else {
            Toast.makeText(this, "Incorrect Answer, Try Again!", Toast.LENGTH_SHORT).show();
        }
    }

}  // Kelas ditutup di sini