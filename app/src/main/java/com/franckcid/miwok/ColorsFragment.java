package com.franckcid.miwok;

import android.app.Activity;
import android.media.AudioManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        View v = layoutInflater.inflate(R.layout.word_list, viewGroup, false);

        ArrayList<Word> words = new ArrayList<>();

        try {
            words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
            words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
            words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
            words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
            words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
            words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
            words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
                                R.raw.color_dusty_yellow));
            words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
                                R.raw.color_mustard_yellow));

            WordAdapter itemsAdapter = new WordAdapter((Activity) viewGroup.getContext(), words, R.color.category_colors);

            ListView listView = (ListView) v.findViewById(R.id.list);

            listView.setAdapter(itemsAdapter);

        }catch(Exception e){
            Toast t = Toast.makeText((Activity) viewGroup.getContext(), "OH CHUCK" + e.getMessage(), Toast.LENGTH_LONG);
            t.show();
        }

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        SoundManager.stopActual();
    }
}
