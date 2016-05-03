package com.shopit.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopit.app.R;

/**
 * Created by veera on 3/5/16.
 */
public class TopStoresAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    LayoutInflater layoutInflater;

    public TopStoresAdapter(Context context) {
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.f_top_stores, parent, false);
        return new TopstoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopstoresViewHolder) {
            TopstoresViewHolder viewHolder = (TopstoresViewHolder) holder;
            viewHolder.nOffers.setText("100 Offers");
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class TopstoresViewHolder extends RecyclerView.ViewHolder {

        TextView nOffers;
        ImageView brandImage;

        public TopstoresViewHolder(View itemView) {
            super(itemView);
            nOffers = (TextView) itemView.findViewById(R.id.numOffers);
            brandImage = (ImageView) itemView.findViewById(R.id.brandIv);
        }
    }
}
