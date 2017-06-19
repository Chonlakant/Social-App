package com.app.sample.social.adpater_viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.sample.social.R;
import com.app.sample.social.mode_product.productImage;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyCustomPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<productImage> list = new ArrayList<>();
    LayoutInflater layoutInflater;


    public MyCustomPagerAdapter(Context context, ArrayList<productImage> list) {
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
        final productImage c = list.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_view);
        //  imageView.setImageResource(images[position]);

        Glide.with(context)
                .load(c.getImageUrl())
                .into(imageView);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}