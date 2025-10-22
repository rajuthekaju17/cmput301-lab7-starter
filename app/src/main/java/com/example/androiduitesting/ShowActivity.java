package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView cityNameView = findViewById(R.id.textView_cityName);
        Button backButton = findViewById(R.id.button_back);

        // Get the city name from intent
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("city_name");

        // Set the city name on the screen
        cityNameView.setText(cityName);

        // Back button to return to MainActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // finishes this activity and returns to MainActivity
            }
        });
    }
}
