package edu.temple.soupimageviewerapp;

import android.content.Context;
import android.media.Image;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private String[] items;
    private int[] imageResources;

    public ImageAdapter (Context context, String[] items, int[] imageResources) {
        this.context = context;
        this.items = items;
        this.imageResources = imageResources;
    }

    @Override
    public int getCount() { return items.length; }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView soupName;
        ImageView soupPicture;
        FrameLayout frameLayout;

        if(convertView == null) {
            soupPicture = new ImageView(context);
            //soupPicture.setLayoutParams(85,85);
            soupPicture.setAdjustViewBounds(true);
            soupPicture.setPadding(8,8,8,8);
        }
        else  {
            soupPicture = (ImageView) convertView;
        }

        /*
        frameLayout = new FrameLayout(context);
        soupName = new TextView(context);
        soupPicture = new ImageView(context);

        frameLayout.addView(soupPicture);
        frameLayout.addView(soupName);

        soupName.setTextSize(20);
        soupName.setPadding(8,8,8,8);



        soupName.setText(items[position]);
         */
        soupPicture.setImageResource(imageResources[position]);
        return soupPicture;
    }
}