package edu.temple.soupimageviewerapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.GridView;
import android.widget.LinearLayout;
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
            frameLayout = new FrameLayout(context);
            soupPicture = new ImageView(context);
            soupName = new TextView(context);
            frameLayout.addView(soupPicture);
            frameLayout.addView(soupName);
            soupPicture.setAdjustViewBounds(true);
            soupPicture.setPadding(8,8,8,8);
        }
        else  {
            frameLayout = (FrameLayout) convertView;
            soupPicture = (ImageView) frameLayout.getChildAt(0);
            soupName = (TextView) frameLayout.getChildAt(1);
        }

        soupPicture.setImageResource(imageResources[position]);
        soupName.setText(items[position]);
        soupName.setGravity(Gravity.CENTER);
        soupName.setTextColor(Color.WHITE);
        soupName.setTextAppearance(R.style.TextShadow);
        soupPicture.setColorFilter(Color.argb(130, 255, 255, 255));

        return frameLayout;
    }
}