package edu.temple.soupimageviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class SelectionActivity extends AppCompatActivity {

    private int[] soupImagesArray;
    private String[] soupArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(getResources().getString(R.string.selection_act_name));
        // get our views so we can use them

        //declare and populate arrays for each for our items, their descriptions, and images of them to be displayed
        soupArray = getResources().getStringArray(R.array.soups_array);
        soupImagesArray = new int[]{R.drawable.gazpacho , R.drawable.french_onion , R.drawable.chowder , R.drawable.tomato};
        // all this is better as an object class as to encapsulate, but since won't be reusing or maintaining this its unnecessary

        GridView grid = (GridView) findViewById(R.id.GridView);
        ImageAdapter adapter = new ImageAdapter(this, soupArray, soupImagesArray);
        grid.setAdapter(adapter);

        //grid listener
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    intent.putExtra("Image", soupImagesArray[position]);
                    intent.putExtra("Name", soupArray[position]);
                    startActivity(intent);
            }
        });

    }

}