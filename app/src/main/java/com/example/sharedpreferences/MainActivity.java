package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_NAME = "lastName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // הפניות לאלמנטים בעיצוב
        TextView tvMessage = findViewById(R.id.tvMessage);
        EditText etInput = findViewById(R.id.etInput);
        Button btnSave = findViewById(R.id.btnSave);

        // קריאת השם האחרון מ-SharedPreferences
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String lastName = preferences.getString(KEY_NAME, "###"); // ברירת מחדל

        // עדכון הטקסט ב-TextView
        tvMessage.setText("Hello " + lastName);

        // מאזין לכפתור השמירה
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // קריאת טקסט מה-EditText
                String newName = etInput.getText().toString();

                // שמירת הטקסט ב-SharedPreferences
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(KEY_NAME, newName);
                editor.apply();

                // עדכון ה-TextView
                tvMessage.setText("Hello " + newName);
            }
        });
    }
}