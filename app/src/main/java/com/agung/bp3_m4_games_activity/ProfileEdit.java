package com.agung.bp3_m4_games_activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ProfileEdit extends AppCompatActivity {

    private static final int REQUEST_IMAGE_PICK = 100;
    private ImageView ivProfileImage;
    private EditText etNickname, etDateOfBirth, etPhoneNumber, etChangePassword, etActiveTime;
    private Button btnSaveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        // Inisialisasi komponen UI
        ivProfileImage = findViewById(R.id.ivProfileImage);
        etNickname = findViewById(R.id.etNickname);
        etDateOfBirth = findViewById(R.id.etDateOfBirth);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etChangePassword = findViewById(R.id.etChangePassword);
        etActiveTime = findViewById(R.id.etActiveTime);
        btnSaveChanges = findViewById(R.id.btnSaveChanges);

        // Event listener
        ivProfileImage.setOnClickListener(v -> openImagePicker());
        etDateOfBirth.setOnClickListener(v -> showDatePicker());
        etActiveTime.setOnClickListener(v -> showTimePicker());
        btnSaveChanges.setOnClickListener(v -> saveChanges());
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePicker view, int selectedYear, int selectedMonth, int selectedDay) -> {
                    String date = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear);
                    etDateOfBirth.setText(date);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void showTimePicker() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (TimePicker view, int selectedHour, int selectedMinute) -> {
                    String time = String.format("%02d:%02d", selectedHour, selectedMinute);
                    etActiveTime.setText(time);
                },
                hour, minute, true // true untuk format 24 jam
        );
        timePickerDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            ivProfileImage.setImageURI(data.getData());
        }
    }

    private void saveChanges() {
        String nickname = etNickname.getText().toString();
        String dateOfBirth = etDateOfBirth.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();
        String activeTime = etActiveTime.getText().toString();
        String password = etChangePassword.getText().toString();

        // Validasi input jika diperlukan
        if (nickname.isEmpty() || dateOfBirth.isEmpty() || phoneNumber.isEmpty() || activeTime.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simpan data ke server atau database (simulasi dengan Toast untuk saat ini)
        Toast.makeText(this, "Changes saved successfully!", Toast.LENGTH_SHORT).show();
    }
}