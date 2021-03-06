package com.app.sample.social.activity_feed_mutiple_image;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sample.social.R;
import com.app.sample.social.activity_comment.CommentsActivity;
import com.app.sample.social.model.Album;
import com.app.sample.social.model.Album2;
import com.app.sample.social.model.ObjectMutiImageAlbum;
import com.app.sample.social.widget.CircleTransform;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAlbumMutiImagePagerAdapter extends PagerAdapter {
    Context context;
   // List<GetPostId> list = new ArrayList<>();
    LayoutInflater layoutInflater;

    List<ObjectMutiImageAlbum> list = new ArrayList<>();
    public MyAlbumMutiImagePagerAdapter(Context context, List<ObjectMutiImageAlbum> list) {
        this.context = context;
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item_image_view_pager, container, false);
        final ObjectMutiImageAlbum c = list.get(position);

        ImageView photo_profile = (ImageView) itemView.findViewById(R.id.photo_profile);
        TextView text_name = (TextView) itemView.findViewById(R.id.text_name);
        TextView text_date = (TextView) itemView.findViewById(R.id.text_date);
        ImageButton bt_like = (ImageButton) itemView.findViewById(R.id.bt_like);
        ImageButton bt_comment = (ImageButton) itemView.findViewById(R.id.bt_comment);
        ImageButton btnMore = (ImageButton) itemView.findViewById(R.id.btnMore);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_view);
        TextSwitcher txt_like = (TextSwitcher) itemView.findViewById(R.id.txt_like);
        TextView txt_count_comments = (TextView) itemView.findViewById(R.id.txt_count_comments);

        Picasso.with(context).load(c.getAvatar()).resize(100, 100).transform(new CircleTransform()).into(photo_profile);
        text_name.setText(c.getUsername());
        text_date.setText(c.getTimeStamp());
        txt_like.setText(c.getCountLike()+" Likes");
        txt_count_comments.setText(c.getCountComment()+"  รายการ");
        Glide.with(context)
                .load(c.getImage())
                .into(imageView);

        if(c.isLike() == true){

            bt_like.setImageResource(R.drawable.ic_heart_red);

        }else{

            bt_like.setImageResource(R.drawable.ic_heart_outline_grey);
        }

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CommentsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                i.putExtra("postId", c.getPostId());
                context.startActivity(i);
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}