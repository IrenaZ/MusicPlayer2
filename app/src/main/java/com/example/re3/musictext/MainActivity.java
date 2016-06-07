package com.example.re3.musictext;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String keyIdentifer =  "com.example.re3.musictext";
    Cursor cursor;
    DatabaseHelper sqlHelper;
    ListView list;
    userCursorAdapter userCursor;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
setContentView(R.layout.main);
      list = (ListView) findViewById(R.id.listId);
        FloatingActionButton insertButton = (FloatingActionButton) findViewById(R.id.insert);

         list.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                //Music selectedMusic = (Music)parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedMusic.getName(),
                 //       Toast.LENGTH_SHORT).show();



                Intent intent = new Intent(getApplicationContext(), MediaActivity.class);
                String _id = Long.toString(id);
                intent.putExtra("id",_id);
                //intent.putExtra(keyIdentifer, selectedMusic.getPath());


                startActivity(intent);



            }
        });

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Gallery.class);
                startActivity(intent);
            }
        });


        //List<Music> musicList = new MusicRepository().getAll(this);
        //list.setAdapter(new MusicAdapter(musicList, this));
        //list.setOnItemClickListener(itemListener);

            sqlHelper = new DatabaseHelper(getApplicationContext());


    }

    @Override
    public void onResume(){
        super.onResume();

        cursor = sqlHelper.getAllCursor();

        String [] from = new String[]{DatabaseHelper.COLUMN_PATH};
        int[] to = new int[]{R.id.name};
        userCursor = new userCursorAdapter(this,R.layout.activity_main, cursor,from,to,0);
        list.setAdapter(userCursor);

    }






}
