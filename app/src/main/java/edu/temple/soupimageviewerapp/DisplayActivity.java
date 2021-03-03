package edu.temple.soupimageviewerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView = findViewById(R.id.textViewSoupName);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("Name");
        int image = extras.getInt("Image");

        textView.setText(name);
        imageView.setImageResource(image);
    }
}