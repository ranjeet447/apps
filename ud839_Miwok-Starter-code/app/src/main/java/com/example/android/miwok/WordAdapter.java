package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ranjeet on 9/26/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
      private int mColorResourseId;

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        public WordAdapter(Activity context, ArrayList<Word> words, int colorResourseId) {
        super(context, 0, words);
         mColorResourseId = colorResourseId;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


            // Get the {@link Word} object located at this position in the list
            Word currentWord = getItem(position);

            // Find the TextView in the list_item.xml layout with the miwok_text_view
            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
            // Get the miwok translation from the current Word object and
            // set this text on the miwok TextView
            miwokTextView.setText(currentWord.getMiwokTranslation());

            // Find the TextView in the list_item.xml layout with the ID default_text_view
            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            // Get the default text from the current Word object and
            // set this text on the english Text
            defaultTextView.setText(currentWord.getDefaultTranslation());

             ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

             if(currentWord.hasImage()){
                 imageView.setImageResource(currentWord.getResourceId());
                 imageView.setVisibility(View.VISIBLE);
             }
             else {
                 imageView.setVisibility(View.GONE);
             }

             View textContainer = listItemView.findViewById(R.id.text_container);
             int color = ContextCompat.getColor(getContext(),mColorResourseId);
               textContainer.setBackgroundColor(color);

        return listItemView;
        }

    }
