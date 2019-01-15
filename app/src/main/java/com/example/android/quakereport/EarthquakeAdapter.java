package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        cityTextView.setText(currentEarthquake.getmCity());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        magTextView.setText(currentEarthquake.getmMag());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        dateTextView.setText(currentEarthquake.getmDate());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
