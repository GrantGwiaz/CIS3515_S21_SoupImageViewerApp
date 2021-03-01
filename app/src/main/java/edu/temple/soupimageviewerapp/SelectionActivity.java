package edu.temple.soupimageviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectionActivity extends AppCompatActivity {

    Spinner spinner;


    int[] soupImagesArray;
    String[] soupArray;
    String[] descriptionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get our views so we can use them
        spinner = findViewById(R.id.spinner);

        //declare and populate arrays for each for our items, their descriptions, and images of them to be displayed
        soupArray = new String[]{"Please select a Soup","Gazpacho", "French Onion Soup", "Chowder", "Tomato Soup"};
        descriptionArray = new String[]{ "" ," - a cold soup of raw blended vegetables", " - beef stock and onion base, covered with cheese and bread",
                " - a rich soup typically containing fish", " - pretty much just tomatoes"};
        soupImagesArray = new int[]{R.drawable.gazpacho , R.drawable.french_onion , R.drawable.chowder , R.drawable.tomato};
        // all this is better as an object class as to encapsulate, but since won't be reusing or maintaining this its unnecessary


        ImageAdapter adapter = new ImageAdapter(this, soupArray, descriptionArray, soupImagesArray);
        spinner.setAdapter(adapter);

        //spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0) {
                    Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    intent.putExtra("soupImagesArray", soupImagesArray);
                    startActivity(intent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SelectionActivity.this, "Item Unselected", Toast.LENGTH_SHORT).show();
            }

        });
    }
}