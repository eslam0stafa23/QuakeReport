package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        String location = currentEarthquake.getmLocation();
        String primaryLocation = currentEarthquake.getmLocation();
        String offsetLocation;
        if (location.contains("of")) {
            String[] locations = location.split("of");
            primaryLocation = locations[0];
            offsetLocation = locations[1];
        } else offsetLocation = "Near the";

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        primaryLocationTextView.setText(primaryLocation);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView offsetLocationTextView = (TextView) listItemView.findViewById(R.id.offset_location_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        offsetLocationTextView.setText(offsetLocation);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getmMag());
        magTextView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getmDateInMilliseconds());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // set the image to iconView
        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {

        int magnitude1Color;

        switch ((int) magnitude) {
            case 1:
                magnitude1Color = R.color.magnitude1;
                break;

            case 2:
                magnitude1Color = R.color.magnitude2;
                break;

            case 3:
                magnitude1Color = R.color.magnitude3;
                break;

            case 4:
                magnitude1Color = R.color.magnitude4;
                break;

            case 5:
                magnitude1Color = R.color.magnitude5;
                break;

            case 6:
                magnitude1Color = R.color.magnitude6;
                break;

            case 7:
                magnitude1Color = R.color.magnitude7;
                break;

            case 8:
                magnitude1Color = R.color.magnitude8;
                break;

            case 9:
                magnitude1Color = R.color.magnitude9;
                break;

            default:
                magnitude1Color = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitude1Color);
    }


}
