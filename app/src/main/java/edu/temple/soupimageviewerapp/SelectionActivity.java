package edu.temple.soupimageviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectionActivity extends AppCompatActivity {

    private Spinner spinner;


    private int[] soupImagesArray;
    private String[] soupArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(getResources().getString(R.string.selection_act_name));
        // get our views so we can use them
        spinner = findViewById(R.id.spinner);

        //declare and populate arrays for each for our items, their descriptions, and images of them to be displayed
        soupArray = new String[]{"Please select a Soup","Gazpacho", "French Onion Soup", "Chowder", "Tomato Soup"};
        soupImagesArray = new int[]{R.drawable.gazpacho , R.drawable.french_onion , R.drawable.chowder , R.drawable.tomato};
        // all this is better as an object class as to encapsulate, but since won't be reusing or maintaining this its unnecessary


        ImageAdapter adapter = new ImageAdapter(this, soupArray, soupImagesArray);
        spinner.setAdapter(adapter);

        //spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    intent.putExtra("Image", soupImagesArray[position-1]);
                    intent.putExtra("Name", soupArray[position]);
                    startActivity(intent);
                    spinner.setSelection(0);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SelectionActivity.this, "Item Unselected", Toast.LENGTH_SHORT).show();
            }

        });
    }
}