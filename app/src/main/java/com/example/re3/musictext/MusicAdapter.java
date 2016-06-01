package com.example.re3.musictext;

/**
 * Created by re3 on 30.05.16.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//private Music getModel(int position) {
//      return(((MusicAdapter)getListAdapter()).getItem(position));
//     }
class MusicAdapter extends ArrayAdapter<Music> {

    private LayoutInflater mInflater;
    private final Activity context;



    MusicAdapter(List <Music> music1, Activity context) {
        super(context,R.layout.activity_main,music1);
        this.context = context;
        mInflater = context.getLayoutInflater();
    }
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ViewHolder holder;
        View row=convertView;
        if(row==null){

            row = mInflater.inflate(R.layout.activity_main, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.album_pic);
            holder.nameView = (TextView) row.findViewById(R.id.name);

            row.setTag(holder);
        }
        else{

            holder = (ViewHolder)row.getTag();
        }

        Music audio = this.getItem(position);

        holder.imageView.setImageBitmap((audio.getAlbum_pic()));
        holder.nameView.setText(audio.getName());



        return row;
    }

    class ViewHolder {
        public ImageView imageView;
        public TextView nameView;
    }
}

