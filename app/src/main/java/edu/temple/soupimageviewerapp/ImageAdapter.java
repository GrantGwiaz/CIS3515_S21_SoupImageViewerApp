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

        FrameLayout frameLayout;

        if(convertView == null) {
            linearLayout = new LinearLayout(context);
            soupName = new TextView(context);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(soupName);

            soupName.setTextSize(20);
            soupName.setPadding(30, 30,15,0);
            linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        } else {
            linearLayout = (LinearLayout) convertView;
            soupName = (TextView) linearLayout.getChildAt(0);
            linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        }
        soupName.setText(items[position]);

        return linearLayout;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView soupName;
        ImageView imageView;

        LinearLayout linearLayout;

        if(convertView == null) {
            linearLayout = new LinearLayout(context);
            soupName = new TextView(context);
            imageView = new ImageView(context);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(imageView);
            linearLayout.addView(soupName);

            soupName.setTextSize(15);
            soupName.setPadding(15, 30,15,0);


            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;

        } else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            soupName = (TextView) linearLayout.getChildAt(1);
        }
        if(position > 0) {
            imageView.setImageResource(imageResources[position - 1]);
        } else {
            imageView.setImageResource(android.R.color.transparent);
        }
        soupName.setText(items[position]);

        return linearLayout;
    }
}