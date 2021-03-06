package com.ostap_kozak.newsfeed;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ostapkozak on 27/02/2017.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNewsList;

    // Store context for easy access.
    private Context mContext;

    public NewsAdapter(Context context, List<News> newsList) {
        mNewsList = newsList;
        mContext = context;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.card_view_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        News news = mNewsList.get(position);

        ImageView news_image = holder.newsImage;
        TextView news_title = holder.newsTitle;
        TextView news_description = holder.newsDescription;
        TextView news_time = holder.newsTime;

        Glide.with(getContext()).load(news.getImageUrl()).into(news_image);
        news_title.setText(news.getTitle());
        news_description.setText(news.getDescription());

        news_time.setText(Utils.convertNewsTimePublication(news.getTime()));
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    // We specify custom ViewHolder which gives us access to our views
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView newsImage;
        TextView newsTitle, newsDescription, newsTime;

        public ViewHolder(View itemView) {
            super(itemView);

            newsImage = (ImageView) itemView.findViewById(R.id.news_image);
            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsDescription = (TextView) itemView.findViewById(R.id.news_description);
            newsTime = (TextView) itemView.findViewById(R.id.news_time);

        }
    }

    private Context getContext() {
        return mContext;
    }


}
