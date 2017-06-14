package com.app.sample.social.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsListAdapter extends RecyclerView.Adapter<ProductDetailsListAdapter.ViewHolder> {

    private List<productDetails> original_items = new ArrayList<>();


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView titleConpany;
        public TextView content;
        public TextView time;
        public ImageView image;
        public TextView title;
        public TextView desc;
        public TextView price;
        public TextView location;
        public TextView type;
        public TextView status;
        public LinearLayout lyt_parent;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.txt_title);
            desc = (TextView) v.findViewById(R.id.txt_dec);
            price = (TextView) v.findViewById(R.id.txt_price);
            location = (TextView) v.findViewById(R.id.txt_location);
            type = (TextView) v.findViewById(R.id.txt_type);
            status = (TextView) v.findViewById(R.id.txt_status);
            titleConpany = (TextView) v.findViewById(R.id.title);
            content = (TextView) v.findViewById(R.id.content);
            time = (TextView) v.findViewById(R.id.time);
            image = (ImageView) v.findViewById(R.id.image);
            lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
        }

    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductDetailsListAdapter(Context ctx, List<productDetails> items) {
        this.ctx = ctx;
        original_items = items;

    }

    @Override
    public ProductDetailsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_details, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final productDetails c = original_items.get(position);
        holder.titleConpany.setText(c.getHtml().get(position).getSeller().getFirst_name() + c.getHtml().get(position).getSeller().getLast_name());

        holder.time.setText(".....");
        holder.content.setText(c.getHtml().get(position).getTime());

        Picasso.with(ctx).load(c.getHtml().get(position).getSeller().getAvatar())
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(holder.image);

        setAnimation(holder.itemView, position);
        holder.title.setText(c.getHtml().get(position).getName());

        String html = c.getHtml().get(position).getDescription(); // your html
        String result = Html.fromHtml(html).toString();

        holder.desc.setText(result);
        holder.price.setText(c.getHtml().get(position).getPrice()+ "(บาท)");
        holder.location.setText(c.getHtml().get(position).getLocation());

        if(c.getHtml().get(position).getType().equals("0")){
            holder.type.setText("ใหม่");
        }else{
            holder.type.setText("เก่า");
        }

        if(c.getHtml().get(position).getStatus().equals("0")){
            holder.status.setText("มีสินค้า");
        }else{
            holder.status.setText("ไม่มีสินค้า");
        }



        // view detail
        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, position);
                }

            }
        });

        holder.lyt_parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });
    }


    // Here is the key method to apply the animation
    private int lastPosition = -1;

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.slide_in_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return original_items.size();
    }


}