package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ml extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml);
        final ArrayList<s> songs= new ArrayList<s>();
        songs.add(new s("Everybody hates me","ChainSmoker",R.raw.sickboy));


        SA item=new SA(this,songs);
        ListView list=(ListView) findViewById(R.id.list);
        list.setAdapter(item);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long id) {
                s song=songs.get(position);
                mp= MediaPlayer.create(ml.this,song.getAudio());
                mp.start();

            }
});
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.pause();
    }
}