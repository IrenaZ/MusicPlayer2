package com.example.re3.musictext;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;

/**
 * Created by re3 on 07.06.16.
 */
public class userCursorAdapter extends SimpleCursorAdapter {
private int _layout;
    public userCursorAdapter(Context context, int layout, Cursor cursor, String [] from, int[] to,int flags) {
        super(context, layout, cursor, from, to, flags);
                _layout=layout;
    }

@Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(_layout,parent, false);
    return view;

}

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        super.bindView(view,context,cursor);
    }

}
