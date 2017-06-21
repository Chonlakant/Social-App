package com.app.sample.social.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Header;
import com.app.sample.social.widget.CircleTransform;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FeedUserListAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_TEXT = 1;
    private static final int TYPE_PHOTO = 2;
    private static final int TYPE_VDEIO = 3;
    private static final int TYPE_FILE = 4;
    private static final int TYPE_MP3 = 5;
    private static final int TYPE_MAPS = 6;
    private static final int TYPE_YOUTUBE = 7;
    private static final int TYPE_SOUNDCOULD = 8;

    private List<FeedUser> items = new ArrayList<>();

    private Context ctx;
    Header header;

    public static FeedListAdapter2.OnItemClickLike mItemClickLike;
    public static FeedListAdapter2.OnPhotoClick mPhotoClick;
    public static FeedListAdapter2.OnCommentClick mCommentClick;
    public static FeedListAdapter2.OnShareClick mShareClick;
    public static FeedListAdapter2.OnMoreClick mMoreClick;


    public interface OnItemClickLike {
        public void onItemClickLike(View view, int position);
    }

    public void SetOnItemClickLike(final FeedListAdapter2.OnItemClickLike mItemClickLike) {
        this.mItemClickLike = mItemClickLike;
    }

    public interface OnPhotoClick {
        public void onPhotoClick(View view, int position);
    }

    public void SetOnPhotoClick(final FeedListAdapter2.OnPhotoClick mPhotoClick) {
        this.mPhotoClick = mPhotoClick;
    }

    public interface OnCommentClick {
        public void onCommentClick(View view, int position);
    }

    public void SetOnCommentClick(final FeedListAdapter2.OnCommentClick mCommentClick) {
        this.mCommentClick = mCommentClick;
    }

    public interface OnShareClick {
        public void onShareClick(View view, int position);
    }

    public void SetOnShareClick(final FeedListAdapter2.OnShareClick mShareClick) {
        this.mShareClick = mShareClick;
    }

    public interface OnMoreClick {
        public void onMoreClick(View view, int position);
    }

    public void SetOnMoreClick(final FeedListAdapter2.OnMoreClick mMoreClick) {
        this.mMoreClick = mMoreClick;
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public FeedUserListAdapter(Context ctx, List<FeedUser> items, Header header) {
        this.ctx = ctx;
        this.items = items;
        this.header = header;
    }

    @Override
    public int getItemViewType(int position) {

//        if (isPositionHeader(position))
//            return TYPE_HEADER;
//        if (isPositionText(position))
//            return TYPE_TEXT;
//        if (isPositionPhoto(position))
//            return TYPE_PHOTO;
//        if (isPositionFile(position))
//            return TYPE_FILE;

        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }

        if (items.get(position).getItems().get(position).getPost_type2() == 1) {
            return TYPE_TEXT;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 2) {
            return TYPE_PHOTO;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 3) {
            return TYPE_VDEIO;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 4) {
            return TYPE_FILE;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 5) {
            return TYPE_MP3;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 6) {
            return TYPE_MAPS;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 7) {
            return TYPE_YOUTUBE;
        }
        if (items.get(position).getItems().get(position).getPost_type2() == 8) {
            return TYPE_SOUNDCOULD;
        }


        Log.e("TYPE_9", items.get(position).getItems().get(position).getPost_type2() + "");

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


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View vHeader = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
            return new FeedUserListAdapter.VHHeader(vHeader);
        } else if (viewType == TYPE_TEXT) {
            View vItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_text, parent, false);
            return new FeedUserListAdapter.VHItem(vItem);
        } else if (viewType == TYPE_PHOTO) {
            View vPhoto = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_photo, parent, false);
            return new FeedUserListAdapter.VHPhoto(vPhoto);
        } else if (viewType == TYPE_VDEIO) {
            View vVideo = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_video, parent, false);
            return new FeedUserListAdapter.VHViedo(vVideo);
        } else if (viewType == TYPE_FILE) {
            View VHFile = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_file, parent, false);
            return new FeedUserListAdapter.VHFile(VHFile);
        } else if (viewType == TYPE_MP3) {
            View vHMp3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_mp3, parent, false);
            return new FeedUserListAdapter.VHMp3(vHMp3);
        } else if (viewType == TYPE_MAPS) {
            View vHMaps = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_maps, parent, false);
            return new FeedUserListAdapter.VHMaps(vHMaps);
        } else if (viewType == TYPE_YOUTUBE) {
            View vHYtube = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_youtube, parent, false);
            return new FeedUserListAdapter.VHYoutube(vHYtube);
        } else if (viewType == TYPE_SOUNDCOULD) {
            View vHSoundCloud = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_soundcloud, parent, false);
            return new FeedUserListAdapter.VHSoundCloud(vHSoundCloud);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final FeedUser p = items.get(position);
        if (holder.getItemViewType() == TYPE_HEADER) {

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            FeedUserListAdapter.VHHeader VHheader = (FeedUserListAdapter.VHHeader) holder;
            Glide.with(ctx)
                    .load(avatar)
                    .into(VHheader.avatar_title);

        }

        if (holder.getItemViewType() == TYPE_TEXT) {

            FeedUserListAdapter.VHItem VHitem = (FeedUserListAdapter.VHItem) holder;
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
            FeedUserListAdapter.VHPhoto VHPhoto = (FeedUserListAdapter.VHPhoto) holder;

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
            FeedUserListAdapter.VHViedo VHViedo = (FeedUserListAdapter.VHViedo) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHViedo.photo);
            VHViedo.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String title = p.getItems().get(position).getPost_data().getPost_text();
            VHViedo.txt_title_video.setText(title);
//            Glide.with(ctx)
//                    .load(cover)
//                    .into(VHPhoto.photo_content);

        }
        if (holder.getItemViewType() == TYPE_FILE) {
            FeedUserListAdapter.VHFile VHFile = (FeedUserListAdapter.VHFile) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHFile.photo);
            VHFile.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String postFifle = p.getItems().get(position).getPost_data().getPost_file();
            String postText = p.getItems().get(position).getPost_data().getPost_text();

            VHFile.text_fifle.setText(postFifle);
            VHFile.text_content_title.setText(postText);

        }
        if (holder.getItemViewType() == TYPE_MP3) {
            FeedUserListAdapter.VHMp3 VHMp3 = (FeedUserListAdapter.VHMp3) holder;

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

        }
        if (holder.getItemViewType() == TYPE_MAPS) {
            FeedUserListAdapter.VHMaps VHMaps = (FeedUserListAdapter.VHMaps) holder;

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
            FeedUserListAdapter.VHYoutube VHYoutube = (FeedUserListAdapter.VHYoutube) holder;

            String avatar = p.getItems().get(position).getPublisher_data().getProfile_picture();
            Picasso.with(ctx)
                    .load(avatar)
                    .resize(80, 80)
                    .transform(new CircleTransform())
                    .into(VHYoutube.photo);
            VHYoutube.text_name.setText(p.getItems().get(position).getPublisher_data().getUsername());

            String postFifle = p.getItems().get(position).getPost_data().getPost_file();
            String postText = p.getItems().get(position).getPost_data().getPost_text();


        }

        if (holder.getItemViewType() == TYPE_SOUNDCOULD) {
            FeedUserListAdapter.VHSoundCloud VHSoundCloud = (FeedUserListAdapter.VHSoundCloud) holder;

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


}