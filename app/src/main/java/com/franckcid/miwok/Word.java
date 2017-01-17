package com.franckcid.miwok;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by franck on 13/01/17.
 */

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int imageId;
    private int soundID;

    public Word(String d, String m){

        defaultTranslation = d;
        miwokTranslation = m;
        imageId = 0;
        soundID = 0;

    }

    public Word(String d, String m, int imgId){

        defaultTranslation = d;
        miwokTranslation = m;
        imageId = imgId;
        soundID = 0;

    }

    public Word(String d, String m, int imgId, int soundId){

        defaultTranslation = d;
        miwokTranslation = m;
        imageId = imgId;
        soundID = soundId;

    }

    public String getDefaultTranslation(){
        return defaultTranslation;
    }

    public String getMiwokTranslation(){
        return miwokTranslation;
    }

    public int getImageId(){ return imageId; }

    public int getSoundID(){ return  soundID;}

}
