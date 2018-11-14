package com.example.mike.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    // create (empty) arraylist to store friends
    private ArrayList<Friend> friends = new ArrayList<>();

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> friends) {
        super(context, resource, friends);
        this.friends = friends;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        TextView friendName = convertView.findViewById(R.id.friendName);
        ImageView friendPhoto = convertView.findViewById(R.id.friendPhoto);


        friendName.setText(friends.get(position).getName());
        friendPhoto.setImageDrawable(getContext().getDrawable(friends.get(position).getDrawableId()));

        return convertView;
    }
}
