package com.example.mike.friendsr;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {

    // create arraylist to stash friend objects
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create friend objects linked to drawables
        Friend arya = new Friend("Arya Stark", "Faceless (wo)man", getResources().getIdentifier("arya", "drawable", this.getPackageName()));
        Friend cersei = new Friend("Cersei Lannister", "Bitch queen", getResources().getIdentifier("cersei", "drawable", this.getPackageName()));
        Friend daenerys = new Friend("Daenerys Targaryan", "Dragon queen", getResources().getIdentifier("daenerys", "drawable", this.getPackageName()));
        Friend jaime = new Friend("Jaime Lannister", "Kingsguard lion", getResources().getIdentifier("jaime", "drawable", this.getPackageName()));
        Friend jon = new Friend("Jon Snow", "King of the North", getResources().getIdentifier("jon", "drawable", this.getPackageName()));
        Friend jorah = new Friend("Jorah Mormont", "Lord of Bear Island", getResources().getIdentifier("jorah", "drawable", this.getPackageName()));
        Friend margaery = new Friend("Margaery Tyrell", "Flower lady",getResources().getIdentifier("margaery", "drawable", this.getPackageName()));
        Friend melisandre = new Friend("Melisandre", "Red priestess", getResources().getIdentifier("melisandre", "drawable", this.getPackageName()));
        Friend sansa = new Friend("Sansa Stark", "Northern lady", getResources().getIdentifier("sansa", "drawable", this.getPackageName()));
        Friend tyrion = new Friend("Tyrion Lannister", "Witty dwarf", getResources().getIdentifier("tyrion", "drawable", this.getPackageName()));

        // add friend objects to ArrayList
        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        // create an adapter to and link list of friends to grid
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new GridItemClickListener());
    }

    // when one of the friend profiles is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // find out which friend was clicked
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            // add clicked friend to intent and go to profile activity
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
