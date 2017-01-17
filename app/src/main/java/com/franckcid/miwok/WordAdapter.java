package com.franckcid.miwok;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by franck on 13/01/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int activityColor;

    public WordAdapter(Activity activity, ArrayList<Word> words, int actColor) {
        super(activity, 0, words);
        activityColor = actColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View list = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        final Word cWord = getItem(position);

        ImageView ivImage = (ImageView) list.findViewById(R.id.image);
        ivImage.setImageResource(cWord.getImageId());
        if(cWord.getImageId() == 0)
            ivImage.setVisibility(View.GONE);

        TextView tvDefault = (TextView) list.findViewById(R.id.def);
        tvDefault.setText(cWord.getDefaultTranslation());

        TextView tvWiwok = (TextView) list.findViewById(R.id.miwok);
        tvWiwok.setText(cWord.getMiwokTranslation());

        list.setBackgroundColor(getContext().getResources().getColor(activityColor));

        if(cWord.getSoundID() != 0) {
            RelativeLayout item = (RelativeLayout) list.findViewById(R.id.list_item);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SoundManager.playOnly(WordAdapter.this.getContext(), cWord.getSoundID());
                }
            });
        }

        return list;
    }
}
