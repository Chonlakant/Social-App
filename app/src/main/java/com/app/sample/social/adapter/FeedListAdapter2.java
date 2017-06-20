package com.app.sample.social.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.app.sample.social.R;
import com.app.sample.social.activity_viedo_full.ActivityFullVideo;
import com.app.sample.social.activity_youtube.ActivityYoutube;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.Header;
import com.app.sample.social.widget.CircleTransform;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FeedListAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_TEXT = 1;
    private static final int TYPE_PHOTO = 2;
    private static final int TYPE_VDEIO = 3;
    private static final int TYPE_FILE = 4;
    private static final int TYPE_MP3 = 5;
    private static final int TYPE_MAPS = 6;
    private static final int TYPE_YOUTUBE = 7;
    private static final int TYPE_SOUNDCOULD = 8;
    private static final int TYPE_COMMENT = 9;

    private List<Feed2> items = new ArrayList<>();

    private Context ctx;
    Header header;

    AudioManager audioManager;
    Timer timer;
    int mediaFileLengthInMilliseconds;
    Handler handler;



    public static OnItemClickLike mItemClickLike;
    public static OnPhotoClick mPhotoClick;
    public static OnCommentClick mCommentClick;
    public static OnShareClick mShareClick;
    public static OnMoreClick mMoreClick;


    // Provide a suitable constructor (depends on the kind of dataset)
    public FeedListAdapter2(Context ctx, List<Feed2> items, Header header) {
        this.ctx = ctx;
        this.items = items;
        this.header = header;

    }

    public interface OnItemClickLike {
        public void onItemClickLike(View view, int position);
    }

    public void SetOnItemClickLike(final OnItemClickLike mItemClickLike) {
        this.mItemClickLike = mItemClickLike;
    }

    public interface OnPhotoClick {
        public void onPhotoClick(View view, int position);
    }

    public void SetOnPhotoClick(final OnPhotoClick mPhotoClick) {
        this.mPhotoClick = mPhotoClick;
    }

    public interface OnCommentClick {
        public void onCommentClick(View view, int position);
    }

    public void SetOnCommentClick(final OnCommentClick mCommentClick) {
        this.mCommentClick = mCommentClick;
    }

    public interface OnShareClick {
        public void onShareClick(View view, int position);
    }

    public void SetOnShareClick(final OnShareClick mShareClick) {
        this.mShareClick = mShareClick;
    }

    public interface OnMoreClick {
        public void onMoreClick(View view, int position);
    }

    public void SetOnMoreClick(final OnMoreClick mMoreClick) {
        this.mMoreClick = mMoreClick;
    }




    @Override
    public int getItemViewType(int position) {


        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }

       else if (items.get(position).getItems().get(position).getPost_type2() == 1) {

            return TYPE_TEXT;
        }

        else if (items.get(position).getItems().get(position).getPost_type2() == 2) {
            return TYPE_PHOTO;
        }
        else if (items.get(position).getItems().get(position).getPost_type2() == 3) {
            return TYPE_VDEIO;
        }
        else if (items.get(position).getItems().get(position).getPost_type2() == 4) {
            return TYPE_FILE;
        }
        else if (items.get(position).getItems().get(position).getPost_type2() == 5) {
            return TYPE_MP3;
        }
        else  if (items.get(position).getItems().get(position).getPost_type2() == 6) {
            return TYPE_MAPS;
        }
        else if (items.get(position).getItems().get(position).getPost_type2() == 7) {
            return TYPE_YOUTUBE;
        }
        else  if (items.get(position).getItems().get(position).getPost_type2() == 8) {
            return TYPE_SOUNDCOULD;
        }




//        Log.e("TYPE_9", items.get(position).getItems().get(position).getPost_type2() + "");

        return TYPE_TEXT;

    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private boolean isPositionText(int position) {
        return position == 1;
    }

    private boolean isPositionPhoto(int position) {
        return position == 2;
    }

    private boolean isPositionFile(int position) {
        return position == 3;
    }

    private boolean isPositionVDEIO(int position) {
        return position == 4;
    }

    private boolean isPositionMAPS(int position) {
        return position == 5;
    }

    private boolean isPositionMP3(int position) {
        return position == 6;
    }

    private boolean isPositionComment(int position) {
        return position == 9;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("viewType",viewType+"");

        if (viewType == TYPE_HEADER) {
            View vHeader2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
            return new VHHeader(vHeader2);
        } else if (viewType == TYPE_TEXT) {
            View vItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_text, parent, false);
            return new VHItem(vItem);
        } else if (viewType == TYPE_PHOTO) {
            View vPhoto = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_photo, parent, false);
            return new VHPhoto(vPhoto);
        } else if (viewType == TYPE_VDEIO) {
            View vVideo = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_video, parent, false);
            return new VHViedo(vVideo);
        } else if (viewType == TYPE_FILE) {
            View VHFile = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_file, parent, false);
            return new VHFile(VHFile);
        } else if (viewType == TYPE_MP3) {
            View vHMp3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_mp3, parent, false);
            return new VHMp3(vHMp3);
        } else if (viewType == TYPE_MAPS) {
            View vHMaps = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_maps, parent, false);
            return new VHMaps(vHMaps);
        } else if (viewType == TYPE_YOUTUBE) {
            View vHYtube = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_youtube, parent, false);
            return new VHYoutube(vHYtube);
        } else if (viewType == TYPE_SOUNDCOULD) {
            View vHSoundCloud = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_soundcloud, parent, false);
            return new VHSoundCloud(vHSoundCloud);
        }
        else if (viewType == TYPE_COMMENT) {
            View vHComment = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tap_comments, parent, false);
            return new VHComment(vHComment);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Feed2 p = items.get(position);
        if (holder.getItemViewType() == TYPE_HEADER) {

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            VHHeader VHheader = (VHHeader) holder;
            Glide.with(ctx)
                    .load(avatar)
                    .into(VHheader.avatar_title);

        }

        if (holder.getItemViewType() == TYPE_TEXT) {

            VHItem VHitem = (VHItem) holder;
            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHitem.photo);
            VHitem.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());


            String html = p.getItems().get(position).getPost_data().getPost_text();
            String result = Html.fromHtml(html).toString();
            VHitem.text_content.setText(result);

            VHitem.text_date.setText(p.getItems().get(position).getPost_data().getPost_time());

        }
        if (holder.getItemViewType() == TYPE_PHOTO) {
            VHPhoto VHPhoto = (VHPhoto) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHPhoto.photo);
            VHPhoto.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String cover = p.getItems().get(position).getPost_data().getPost_file();
            Glide.with(ctx)
                    .load(cover)
                    .into(VHPhoto.photo_content);

        }

        if (holder.getItemViewType() == TYPE_VDEIO) {
            VHViedo VHViedo = (VHViedo) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHViedo.photo);
            VHViedo.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String title = p.getItems().get(position).getPost_data().getPost_text();
            final String post_file = p.getItems().get(position).getPost_data().getPost_file();
            VHViedo.txt_title_video.setText(title);
//            Glide.with(ctx)
//                    .load(cover)
//                    .into(VHPhoto.photo_content);

            VHViedo.myvideoView.setVideoPath(post_file);

            //play pause stop

            MediaController mediaController = new MediaController(ctx);
            mediaController.setVisibility(View.GONE);
            mediaController.setAnchorView(VHViedo.myvideoView);
            VHViedo.myvideoView.setMediaController(mediaController);


            // VHViedo.myvideoView.start();

            VHViedo.img_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ctx, ActivityFullVideo.class);
                    i.putExtra("urlvdo", post_file);
                    ctx.startActivity(i);
                }
            });

        }
        if (holder.getItemViewType() == TYPE_FILE) {
            VHFile VHFile = (VHFile) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHFile.photo);
            VHFile.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String postFifle = p.getItems().get(position).getPost_data().getPost_file();
            String postText = p.getItems().get(position).getPost_data().getPost_text();

            VHFile.text_fifle.setText(postText);
            VHFile.text_content_title.setText(postText);

        }
        if (holder.getItemViewType() == TYPE_MP3) {
            final VHMp3 VHMp3 = (VHMp3) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHMp3.photo);
            VHMp3.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String postFifle = p.getItems().get(position).getPost_data().getPost_file();
            String postText = p.getItems().get(position).getPost_data().getPost_text();

            VHMp3.text_mp3.setText(postText);
            VHMp3.text_fifle.setText(postFifle);


            final MediaPlayer mediaPlayer;

            handler = new Handler();


            audioManager = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
            VHMp3.seekBarProgress.setMax(99); // It means 100% .0-99

            mediaPlayer = new MediaPlayer();
            mediaFileLengthInMilliseconds = mediaPlayer.getDuration();

            VHMp3.seekBar2.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            VHMp3.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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


            try {
                mediaPlayer.setDataSource(postFifle); // setup song from http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3 URL to mediaplayer data source
                mediaPlayer.prepare();

            } catch (IOException e) {
                e.printStackTrace();
            }

            VHMp3.txt_time_full.setText(getTimeString(mediaPlayer.getDuration()));

            VHMp3.ButtonTestPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VHMp3.ButtonTestPlay.setVisibility(View.GONE);
                    VHMp3.ButtonTestPause.setVisibility(View.VISIBLE);
                    mediaPlayer.start();

                    VHMp3.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100)); // This math construction give a percentage of "was playing"/"song length"

                    timer = new Timer();

                    TimerTask tt = new TimerTask() {
                        int sec = 0;

                        @Override
                        public void run() {

                            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                VHMp3.txt_time.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        VHMp3.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100));
                                    }
                                });
                            } else {
                                timer.cancel();
                                timer.purge();
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(tt, 0, 1000);


                    if (mediaPlayer != null) {
                        timer = new Timer();

                        TimerTask t = new TimerTask() {
                            int sec = 0;

                            @Override
                            public void run() {

                                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                    VHMp3.txt_time.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            VHMp3.txt_time.setText(getTimeString(mediaPlayer.getCurrentPosition()) + "");
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


            VHMp3.ButtonTestPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VHMp3.ButtonTestPlay.setVisibility(View.VISIBLE);
                    VHMp3.ButtonTestPause.setVisibility(View.GONE);
                    mediaPlayer.pause();
                    mediaFileLengthInMilliseconds = mediaPlayer.getDuration();

                    VHMp3.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100)); // This math construction give a percentage of "was playing"/"song length"
                    if (mediaPlayer.isPlaying()) {
                        Runnable notification = new Runnable() {
                            public void run() {
                                VHMp3.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100)); // This math construction give a percentage of "was playing"/"song length"
                                if (mediaPlayer.isPlaying()) {
                                    Runnable notification = new Runnable() {
                                        public void run() {
                                            VHMp3.seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100));
                                        }
                                    };
                                    handler.postDelayed(notification, 1000);

                                }
                            }
                        };
                        handler.postDelayed(notification, 1000);

                    }
                }
            });

            mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    VHMp3.seekBarProgress.setSecondaryProgress(percent);
                }
            });

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //  VHMp3.ButtonTestPlay.setImageResource(R.drawable.play_100_mp3);
                }
            });

            VHMp3.seekBarProgress.setOnTouchListener(new View.OnTouchListener() {
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
        if (holder.getItemViewType() == TYPE_MAPS) {
            VHMaps VHMaps = (VHMaps) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHMaps.photo);
            VHMaps.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String postFifle = p.getItems().get(position).getPost_data().getPost_file();
            String postText = p.getItems().get(position).getPost_data().getPost_map();

            VHMaps.txt_maps.setText(postText);


        }

        if (holder.getItemViewType() == TYPE_YOUTUBE) {
            VHYoutube VHYoutube = (VHYoutube) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHYoutube.photo);
            VHYoutube.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            final String postYoutube = p.getItems().get(position).getPost_data().getPost_youtube();
            String postText = p.getItems().get(position).getPost_data().getPost_text();
            String post_thumb = p.getItems().get(position).getPost_data().getPost_thumb();


            String s = postYoutube;
            String[] parts = s.split("\\="); // escape .
            String part1 = parts[0];
            final String part2 = parts[1];


            VHYoutube.txt_title_youtube.setText(postText);

            Glide.with(ctx)
                    .load(post_thumb)
                    .into(VHYoutube.photo_youtube);

            VHYoutube.img_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ctx, ActivityYoutube.class);
                    i.putExtra("urlYoutube", part2);
                    ctx.startActivity(i);
                }
            });


        }

        if (holder.getItemViewType() == TYPE_SOUNDCOULD) {
            VHSoundCloud VHSoundCloud = (VHSoundCloud) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHSoundCloud.photo);
            VHSoundCloud.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String postFifle = p.getItems().get(position).getPost_data().getPost_file();
            String postText = p.getItems().get(position).getPost_data().getPost_text();


        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class VHHeader extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle;
        ImageView avatar_title;
        LinearLayout ls_picture;
        LinearLayout ls_location;
        LinearLayout ls_more;

        public VHHeader(View itemView) {
            super(itemView);
            this.txtTitle = (TextView) itemView.findViewById(R.id.title);
            this.avatar_title = (ImageView) itemView.findViewById(R.id.avatar_title);
            this.ls_picture = (LinearLayout) itemView.findViewById(R.id.ls_picture);
            this.ls_location = (LinearLayout) itemView.findViewById(R.id.ls_location);
            this.ls_more = (LinearLayout) itemView.findViewById(R.id.ls_more);


            txtTitle.setOnClickListener(this);
            avatar_title.setOnClickListener(this);
            ls_picture.setOnClickListener(this);
            ls_location.setOnClickListener(this);
            ls_more.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    class VHPhoto extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView text_name;
        ImageView bt_more;
        ImageView bt_like;
        ImageView bt_comment;
        ImageView bt_share;
        TextView text_date;
        TextView txt_like;
        ImageView photo_content;


        public VHPhoto(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);
            photo_content = (ImageView) itemView.findViewById(R.id.photo_content);


        }

        @Override
        public void onClick(View view) {

        }
    }

    class VHMaps extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView text_name;
        ImageView bt_more;
        ImageView bt_like;
        ImageView bt_comment;
        ImageView bt_share;
        TextView text_date;
        TextView txt_like;
        TextView txt_maps;
        ImageView photo_maps;


        public VHMaps(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);
            txt_maps = (TextView) v.findViewById(R.id.txt_maps);
            photo_maps = (ImageView) itemView.findViewById(R.id.photo_maps);


        }

        @Override
        public void onClick(View view) {

        }
    }


    class VHViedo extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView text_name;
        ImageView bt_more;
        ImageView bt_like;
        ImageView bt_comment;
        ImageView bt_share;
        TextView text_date;
        TextView txt_like;
        TextView txt_title_video;
        ImageView photo_video;
        VideoView myvideoView;
        ImageView img_play;


        public VHViedo(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);
            txt_title_video = (TextView) itemView.findViewById(R.id.txt_title_video);
            photo_video = (ImageView) itemView.findViewById(R.id.photo_video);
            myvideoView = (VideoView) itemView.findViewById(R.id.myvideoView);
            img_play = (ImageView) itemView.findViewById(R.id.img_play);
        }

        @Override
        public void onClick(View view) {

        }
    }

    class VHYoutube extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView text_name;
        ImageView bt_more;
        ImageView bt_like;
        ImageView bt_comment;
        ImageView bt_share;
        TextView text_date;
        TextView txt_like;
        ImageView photo_youtube;
        TextView txt_title_youtube;
        ImageView img_play;


        public VHYoutube(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);
            photo_youtube = (ImageView) itemView.findViewById(R.id.photo_youtube);
            txt_title_youtube = (TextView) itemView.findViewById(R.id.txt_title_youtube);
            img_play = (ImageView) itemView.findViewById(R.id.img_play);
        }

        @Override
        public void onClick(View view) {

        }
    }


    class VHMp3 extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView text_name;
        ImageView bt_more;
        ImageView bt_like;
        ImageView bt_comment;
        ImageView bt_share;
        TextView text_date;
        TextView txt_like;
        TextView text_mp3;
        TextView text_fifle;

        ImageButton ButtonTestPlay;
        ImageButton ButtonTestPause;
        SeekBar seekBarProgress;
        SeekBar seekBar2;
        TextView txt_time;
        TextView txt_time_full;


        public VHMp3(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);
            text_mp3 = (TextView) itemView.findViewById(R.id.text_mp3);
            text_fifle = (TextView) itemView.findViewById(R.id.text_fifle);

            ButtonTestPlay = (ImageButton) v.findViewById(R.id.ButtonTestPlay);
            ButtonTestPause = (ImageButton) v.findViewById(R.id.ButtonTestPause);
            seekBarProgress = (SeekBar) v.findViewById(R.id.SeekBarTestPlay);
            txt_time_full = (TextView) v.findViewById(R.id.txt_time_full);
            seekBar2 = (SeekBar) v.findViewById(R.id.seekBar2);
            txt_time = (TextView) v.findViewById(R.id.txt_time);

        }

        @Override
        public void onClick(View view) {

        }
    }

    class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView photo;
        public TextView text_name;
        public ImageView bt_more;
        public ImageView bt_like;
        public ImageView bt_comment;
        public ImageView bt_share;
        public TextView text_date;
        public TextView text_content;
        public TextView txt_like;

        public VHItem(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            text_content = (TextView) v.findViewById(R.id.text_content);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);

            bt_like.setOnClickListener(this);
            bt_comment.setOnClickListener(this);
            bt_share.setOnClickListener(this);
            bt_more.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_like:
                    if (mItemClickLike != null) {
                        mItemClickLike.onItemClickLike(view, getPosition());
                    }
                    break;
                case R.id.photo_content:
                    if (mPhotoClick != null) {
                        mPhotoClick.onPhotoClick(view, getPosition());
                    }
                    break;
                case R.id.bt_comment:
                    if (mCommentClick != null) {
                        mCommentClick.onCommentClick(view, getPosition());
                    }
                    break;
                case R.id.bt_share:
                    if (mShareClick != null) {
                        mShareClick.onShareClick(view, getPosition());
                    }
                    break;
                case R.id.bt_more:
                    if (mMoreClick != null) {
                        mMoreClick.onMoreClick(view, getPosition());
                    }

            }
        }
    }


    class VHSoundCloud extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView photo;
        public TextView text_name;
        public ImageView bt_more;
        public ImageView bt_like;
        public ImageView bt_comment;
        public ImageView bt_share;
        public TextView text_date;
        public TextView text_soundcloud;
        public TextView txt_like;

        public VHSoundCloud(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            text_soundcloud = (TextView) v.findViewById(R.id.text_soundcloud);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);

            bt_like.setOnClickListener(this);
            bt_comment.setOnClickListener(this);
            bt_share.setOnClickListener(this);
            bt_more.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_like:
                    if (mItemClickLike != null) {
                        mItemClickLike.onItemClickLike(view, getPosition());
                    }
                    break;
                case R.id.photo_content:
                    if (mPhotoClick != null) {
                        mPhotoClick.onPhotoClick(view, getPosition());
                    }
                    break;
                case R.id.bt_comment:
                    if (mCommentClick != null) {
                        mCommentClick.onCommentClick(view, getPosition());
                    }
                    break;
                case R.id.bt_share:
                    if (mShareClick != null) {
                        mShareClick.onShareClick(view, getPosition());
                    }
                    break;
                case R.id.bt_more:
                    if (mMoreClick != null) {
                        mMoreClick.onMoreClick(view, getPosition());
                    }

            }
        }
    }

    class VHComment extends RecyclerView.ViewHolder  {


        public VHComment(View v) {
            super(v);

        }


    }


    class VHFile extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView text_name;
        ImageView bt_more;
        ImageView bt_like;
        ImageView bt_comment;
        ImageView bt_share;
        TextView text_date;
        TextView txt_like;
        TextView text_fifle;
        TextView text_content_title;

        public VHFile(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_date = (TextView) v.findViewById(R.id.text_date);
            txt_like = (TextView) v.findViewById(R.id.txt_like);
            text_fifle = (TextView) v.findViewById(R.id.text_fifle);
            text_content_title = (TextView) v.findViewById(R.id.text_content_title);


        }

        @Override
        public void onClick(View view) {

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