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

public class NumbersFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        View v = layoutInflater.inflate(R.layout.word_list, viewGroup, false);

        ArrayList<Word> words = new ArrayList<>();

        try {
            words.add(new Word("one", "lutti", R.drawable.number_one,R.raw.number_one));
            words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
            words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
            words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
            words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
            words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
            words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
            words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
            words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
            words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

            WordAdapter itemsAdapter = new WordAdapter((Activity) viewGroup.getContext(), words, R.color.category_numbers);

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
