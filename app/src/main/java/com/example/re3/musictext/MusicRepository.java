package com.example.re3.musictext;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by re3 on 30.05.16.
 */



public class MusicRepository {
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

    public List<Music> getAll(Context context){

        ArrayList<Music> AudioList = new ArrayList<>();
        try {
            for (String file: context.getAssets().list("MusicDirectory") ){
                AssetFileDescriptor afd=context.getAssets().openFd("MusicDirectory/"+file);
                mediaMetadataRetriever.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());


                String albumName = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
                if (albumName== null){
                    albumName="untitled";
                }

                String path = "MusicDirectory/"+file;
                Uri mus_Uri = Uri.parse(path);
                byte[] art;
                art = mediaMetadataRetriever.getEmbeddedPicture();

                Music aud=new Music();
               /* aud.setName(albumName);
                if(art != null) {
                    aud.setAlbumpic(BitmapFactory.decodeByteArray(art, 0, art.length));
                }*/

                aud.setPath(path);
                //aud.setMus_Uri(mus_Uri);
                AudioList.add(aud);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    return AudioList;
    }
}
