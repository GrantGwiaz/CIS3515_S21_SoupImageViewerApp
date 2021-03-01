package edu.temple.soupimageviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;

public class DisplayActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int image = extras.getInt("Image");

        imageView.setImageResource(image);
    }
}