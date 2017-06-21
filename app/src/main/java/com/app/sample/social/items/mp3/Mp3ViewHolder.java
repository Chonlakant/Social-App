package com.app.sample.social.items.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.app.sample.social.R;


public class Mp3ViewHolder
        extends RecyclerView.ViewHolder {


    public final TextView text_mp3;
    public final ImageButton ButtonTestPlay;
    public final ImageButton ButtonTestPause;
    public final SeekBar seekBarProgress;
    public final SeekBar seekBar2;
    public final TextView txt_time;
    public final TextView txt_time_full;


    public Mp3ViewHolder(final View itemView) {
        super(itemView);

        text_mp3 = (TextView) itemView.findViewById(R.id.text_mp3);
        ButtonTestPlay = (ImageButton) itemView.findViewById(R.id.ButtonTestPlay);
        ButtonTestPause = (ImageButton) itemView.findViewById(R.id.ButtonTestPause);
        seekBarProgress = (SeekBar) itemView.findViewById(R.id.SeekBarTestPlay);
        seekBar2 = (SeekBar) itemView.findViewById(R.id.seekBar2);
        txt_time = (TextView) itemView.findViewById(R.id.txt_time);
        txt_time_full = (TextView) itemView.findViewById(R.id.txt_time_full);
    }
}
