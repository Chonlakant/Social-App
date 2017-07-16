package com.app.sample.social.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.items.image_mutiple.ImageMutipleAdapter;
import com.app.sample.social.model.Notif;
import com.app.sample.social.model.Notifications;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NotifListAdapter extends RecyclerView.Adapter<NotifListAdapter.ViewHolder> implements Filterable {
    public OnItemClickListener mOnItemClickListener;
    private List<Notifications> original_items = new ArrayList<>();
    private List<Notifications> filtered_items = new ArrayList<>();
    private ItemFilter mFilter = new ItemFilter();

    private Context ctx;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView content;
        public TextView date;
        public TextView txt_text_noti;
        public ImageView image;
        public LinearLayout lyt_parent;
        public LinearLayout ls_click;
        public TextView txt_text;

        public ViewHolder(View v) {
            super(v);
            content = (TextView) v.findViewById(R.id.content);
            date = (TextView) v.findViewById(R.id.date);
            image = (ImageView) v.findViewById(R.id.image);
            lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
            ls_click = (LinearLayout) v.findViewById(R.id.ls_click);
            txt_text = (TextView) v.findViewById(R.id.txt_text);
            txt_text_noti = (TextView) v.findViewById(R.id.txt_text_noti);
            lyt_parent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.lyt_parent:
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, getPosition());
                    }

            }
        }
    }

    public Filter getFilter() {
        return mFilter;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NotifListAdapter(Context ctx, List<Notifications> items) {
        this.ctx = ctx;
        original_items = items;
        filtered_items = items;
    }

    @Override
    public NotifListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notif, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Notifications n = filtered_items.get(position);
        //  holder.content.setText(Html.fromHtml(n.getContent()));
        holder.content.setText(n.getNotifications().get(position).getNotifier().getUsername());
        holder.txt_text.setText(n.getNotifications().get(position).getType_text());
        holder.txt_text_noti.setText(n.getNotifications().get(position).getText());
        holder.date.setText(n.getNotifications().get(position).getTime_text_string());
        Picasso.with(ctx).load(n.getNotifications().get(position).getNotifier().getAvatar())
                .resize(60, 60)
                .transform(new CircleTransform())
                .into(holder.image);
       // setAnimation(holder.itemView, position);
        // view detail message conversation

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
        return filtered_items.size();
    }

    @Override
    public long getItemId(int position) {
        return filtered_items.get(position).getNotifications().size();
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String query = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();
            final List<Notifications> list = original_items;
            final List<Notifications> result_list = new ArrayList<>(list.size());

            for (int i = 0; i < list.size(); i++) {
                String str_title = list.get(i).getNotifications().get(i).getNotifier().getUsername();
                if (str_title.toLowerCase().contains(query)) {
                    result_list.add(list.get(i));
                }
            }

            results.values = result_list;
            results.count = result_list.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filtered_items = (List<Notifications>) results.values;
            notifyDataSetChanged();
        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }
}