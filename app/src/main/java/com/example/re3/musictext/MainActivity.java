package com.example.re3.musictext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String keyIdentifer =  "com.example.re3.musictext";

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
setContentView(R.layout.content_main);
       ListView list = (ListView) findViewById(R.id.listId);


        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Music selectedMusic = (Music)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedMusic.getName(),
                        Toast.LENGTH_SHORT).show();



                Intent intent = new Intent(getApplicationContext(), MediaActivity.class);

                intent.putExtra(keyIdentifer, selectedMusic.getPath());


                startActivity(intent);



            }
        };

        List<Music> musicList = new MusicRepository().getAll(this);
        list.setAdapter(new MusicAdapter(musicList, this));
        list.setOnItemClickListener(itemListener);



    }







}
