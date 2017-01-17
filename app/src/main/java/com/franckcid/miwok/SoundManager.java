package com.franckcid.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by franck on 16/01/17.
 */

public class SoundManager {

    public static MediaPlayer mediaPlayer;

    public static void playOnly(Context context, int audioID){
        try {
            stopActual();
            mediaPlayer = MediaPlayer.create(context, audioID);
            mediaPlayer.start();
        }catch (Exception e) {
            Toast t = Toast.makeText(context, "Fail: " + e.getMessage(), Toast.LENGTH_SHORT);
            t.show();
            e.printStackTrace();
        }
    }

    public static void killWhenEnd(){
        if(mediaPlayer != null){
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    public static void stopActual() {
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

}
