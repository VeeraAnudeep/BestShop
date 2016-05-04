package com.shopit.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
            String url = "";
            int random = position % 4;
            switch (random) {
                case 0:
                    url = "http://images.all-free-download.com/images/graphiclarge/lee_logo_29618.jpg";
                    break;
                case 1:
                    url = "https://paytm.com/blog/wp-content/uploads/2014/11/Paytm-Logo.jpg";
                    break;
                case 2:
                    url = "https://upload.wikimedia.org/wikipedia/en/7/78/Big_Bazaar_Logo.jpg";
                    break;
                case 3:
                    url = "http://a02-tata.buildabazaar.com/img/lookandfeel/8661100/da39a3ee5e6b4b0d3255b_zestttt.png.999x213x.png";
                    break;
            }
            Glide.with(mContext)
                    .load(url)
                    .fitCenter()
                    .into(viewHolder.brandImage);
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
