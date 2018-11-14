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

    // when rated by user
    private class OnRatingBarClickListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            // open sharedpreferences and save users rating for that friend
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();

            // set friends rating to that rating
            retrievedFriend.setRating(rating);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // create variables linked to views and ratingbar on ProfileActivity
        ImageView profilePic = findViewById(R.id.profilePic);
        TextView profileName = findViewById(R.id.name);
        TextView bio = findViewById(R.id.bio);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        // set image, name and bio of that friend
        profilePic.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));
        profileName.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());


//        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarClickListener());
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float aStoredFloat = prefs.getFloat(retrievedFriend.getName(),0.0f);

        if (aStoredFloat != 0.0f) {
            // show rating from prefs on rating bar
            ratingBar.setRating(aStoredFloat);
        }

//        ratingBar.setOnRatingBarChangeListener(new OnRatingBarClickListener());

    }
}
