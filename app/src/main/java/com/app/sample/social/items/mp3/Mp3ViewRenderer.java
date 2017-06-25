package com.app.sample.social.items.mp3;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Mp3ViewRenderer extends ViewRenderer<Mp3Model, Mp3ViewHolder> {


    private MediaPlayer mediaPlayer;
    private int mediaFileLengthInMilliseconds;
    private final Handler handler = new Handler();
    AudioManager audioManager;
    Timer timer;


    @NonNull
    private final Listener mListener;



    public Mp3ViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final Mp3Model item, final Mp3ViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final Mp3Model model, @NonNull final Mp3ViewHolder holder) {

        holder.text_mp3.setText(model.getTitle());

        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
        holder.seekBarProgress.setMax(99); // It means 100% .0-99

        mediaPlayer = new MediaPlayer();

        holder.seekBar2.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        holder.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        holder.ButtonTestPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mediaPlayer.setDataSource(model.getUrlfifle());
                    mediaPlayer.prepare();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaFileLengthInMilliseconds = mediaPlayer.getDuration();

                holder.txt_time_full.setText(getTimeString(mediaPlayer.getDuration()));

                mediaFileLengthInMilliseconds = mediaPlayer.getDuration();
                holder.ButtonTestPlay.setVisibility(View.GONE);
                holder.ButtonTestPause.setVisibility(View.VISIBLE);
                mediaPlayer.start();


                primarySeekBarProgressUpdater();


                if (mediaPlayer != null) {
                    timer = new Timer();

                    TimerTask t = new TimerTask() {
                        int sec = 0;

                        @Override
                        public void run() {

                            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                holder.txt_time.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        sec++;
                                        holder.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100));
                                        holder.txt_time.setText(getTimeString(mediaPlayer.getCurrentPosition()) + "");
                                    }
                                });
                            } else {
                                timer.cancel();
                                timer.purge();
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(t, 0, 1000);

                }



            }
        });


        holder.ButtonTestPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mediaPlayer.reset();
                holder.ButtonTestPlay.setVisibility(View.VISIBLE);
                holder.ButtonTestPause.setVisibility(View.GONE);
                mediaPlayer.pause();
                mediaFileLengthInMilliseconds = mediaPlayer.getDuration();
                holder.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100));
                primarySeekBarProgressUpdater();
            }
        });

        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                holder.seekBarProgress.setSecondaryProgress(percent);
            }
        });


        holder.seekBarProgress.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.SeekBarTestPlay) {
                    /** Seekbar onTouch event handler. Method which seeks MediaPlayer to seekBar primary progress position*/
                    if (mediaPlayer.isPlaying()) {
                        SeekBar sb = (SeekBar) v;
                        int playPositionInMillisecconds = (mediaFileLengthInMilliseconds / 100) * sb.getProgress();
                        mediaPlayer.seekTo(playPositionInMillisecconds);

                    }
                }
                return false;
            }
        });
    }

    @NonNull
    @Override
    public Mp3ViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new Mp3ViewHolder(inflate(R.layout.item_list_mp3, parent));
    }

    public interface Listener {
        void onPlayClicked(@NonNull Mp3Model model);
    }

    public interface ListenerPause {
        void onPauseClicked(@NonNull Mp3Model model);
    }

    private void primarySeekBarProgressUpdater() {

        if (mediaPlayer.isPlaying()) {
            final Runnable notification = new Runnable() {
                public void run() {
                    primarySeekBarProgressUpdater();

                }
            };
            handler.postDelayed(notification, 1000);

        }
    }

    private String getTimeString(long millis) {
        StringBuffer buf = new StringBuffer();

        int hours = (int) (millis / (1000 * 60 * 60));
        int minutes = (int) ((millis % (1000 * 60 * 60)) / (1000 * 60));
        int seconds = (int) (((millis % (1000 * 60 * 60)) % (1000 * 60)) / 1000);

        buf
                .append(String.format("%02d", minutes))
                .append(":")
                .append(String.format("%02d", seconds));

        return buf.toString();
    }

}
