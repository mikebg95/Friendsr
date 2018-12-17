package com.example.mike.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get clicked friend from intent
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // create variables linked to views and ratingbar on ProfileActivity
        ImageView profilePic = findViewById(R.id.profilePic);
        TextView profileName = findViewById(R.id.name);
        TextView bio = findViewById(R.id.bio);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        // set listener for rating bar
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarClickListener());

        // set image, name and bio of clicked friend
        profilePic.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));
        profileName.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());

        // get stored rating
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float rating = prefs.getFloat(retrievedFriend.getName(),0.0f);

        if (rating != 0.0f) {
            // show rating from prefs on rating bar
            ratingBar.setRating(rating);
        }

    }

    // when rated by user
    private class OnRatingBarClickListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            // save rating
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();

            // set friends rating to (new) rating
            retrievedFriend.setRating(rating);
        }
    }
}
