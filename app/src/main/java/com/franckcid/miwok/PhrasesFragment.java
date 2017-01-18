package com.franckcid.miwok;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        View v = layoutInflater.inflate(R.layout.word_list, viewGroup, false);

        ArrayList<Word> words = new ArrayList<>();

        try {
            words.add(new Word("Where are you going?", "minto wuksus", 0, R.raw.phrase_where_are_you_going));
            words.add(new Word("What is your name?", "tinnә oyaase'nә", 0, R.raw.phrase_what_is_your_name));
            words.add(new Word("My name is...", "oyaaset...", 0, R.raw.phrase_my_name_is));
            words.add(new Word("How are you feeling?", "michәksәs?", 0, R.raw.phrase_how_are_you_feeling));
            words.add(new Word("I’m feeling good.", "kuchi achit", 0, R.raw.phrase_im_feeling_good));
            words.add(new Word("Are you coming?", "әәnәs'aa?", 0, R.raw.phrase_are_you_coming));
            words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", 0, R.raw.phrase_yes_im_coming));
            words.add(new Word("I’m coming.", "әәnәm", 0, R.raw.phrase_im_coming));
            words.add(new Word("Let’s go.", "yoowutis", 0, R.raw.phrase_lets_go));
            words.add(new Word("Come here.", "әnni'nem", 0, R.raw.phrase_come_here));

            WordAdapter itemsAdapter = new WordAdapter((Activity) viewGroup.getContext(), words, R.color.category_phrases);

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
