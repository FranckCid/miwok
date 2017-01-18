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

public class FamilyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        View v = layoutInflater.inflate(R.layout.word_list, viewGroup, false);

        ArrayList<Word> words = new ArrayList<>();

        try {
            words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
            words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
            words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
            words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
            words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
            words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
            words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
            words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
            words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
            words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

            WordAdapter itemsAdapter = new WordAdapter((Activity) viewGroup.getContext(), words, R.color.category_family);

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
