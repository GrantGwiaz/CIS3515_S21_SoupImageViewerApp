package edu.temple.soupimageviewerapp;

import android.content.Context;
import android.media.Image;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    String[] items;
    String[] descriptions;
    int[] imageResources;

    public ImageAdapter (Context context, String[] items, String[] descriptions, int[] imageResources) {
        this.context = context;
        this.items = items;
        this.descriptions = descriptions;
        this.imageResources = imageResources;
    }

    @Override
    public int getCount() { return items.length; }

    @Override
    public Object getItem(int position) {
        Pair<String, String> soup = new Pair(items[position], descriptions[position]);
        return soup;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView soupName, soupDescription;

        LinearLayout linearLayout;

        if(convertView == null) {
            linearLayout = new LinearLayout(context);
            soupName = new TextView(context);
            soupDescription = new TextView(context);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(soupName);
            linearLayout.addView(soupDescription);

            soupName.setTextSize(20);
            soupName.setPadding(30, 30,15,0);
            soupDescription.setPadding(15, 30,15,30);
            linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        } else {
            linearLayout = (LinearLayout) convertView;
            soupName = (TextView) linearLayout.getChildAt(0);
            soupDescription = (TextView) linearLayout.getChildAt(1);
            linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        }
        soupName.setText(items[position]);
        soupDescription.setText(descriptions[position]);

        return linearLayout;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView soupName, soupDescription;
        ImageView imageView;

        LinearLayout linearLayout;

        if(convertView == null) {
            linearLayout = new LinearLayout(context);
            soupName = new TextView(context);
            soupDescription = new TextView(context);
            imageView = new ImageView(context);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(imageView);
            linearLayout.addView(soupName);
            linearLayout.addView(soupDescription);

            soupName.setTextSize(15);
            soupName.setPadding(15, 30,15,0);
            soupDescription.setPadding(15, 30,15,30);


            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;

        } else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            soupName = (TextView) linearLayout.getChildAt(1);
            soupDescription = (TextView) linearLayout.getChildAt(2);
        }
        if(position > 0) {
            imageView.setImageResource(imageResources[position - 1]);
        } else {
            imageView.setImageResource(android.R.color.transparent);
        }
        soupName.setText(items[position]);
        soupDescription.setText(descriptions[position]);

        return linearLayout;
    }
}