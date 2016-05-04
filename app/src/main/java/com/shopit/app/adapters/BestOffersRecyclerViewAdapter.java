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
 * Created by veera on 2/5/16.
 */
public class BestOffersRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater layoutInflater;
    Context mContext;

    public BestOffersRecyclerViewAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.offer_card_view, parent, false);
        return new BestOfferItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BestOfferItemViewHolder viewHolder = (BestOfferItemViewHolder) holder;
        viewHolder.brandTitle.setText("Make MyTrip");
        viewHolder.brandOffer.setText("Offers Cashbacks on Domestic Filghts");
//        Glide.with(mContext)
//                .load("lee.in/images/lee_logo.jpg")
//                .fitCenter()
//                .into(viewHolder.brandIv);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class BestOfferItemViewHolder extends RecyclerView.ViewHolder {
        TextView brandTitle;
        TextView brandOffer;
        ImageView brandIv;
        TextView location;

        public BestOfferItemViewHolder(View itemView) {
            super(itemView);
            location = (TextView) itemView.findViewById(R.id.location);
            brandIv = (ImageView) itemView.findViewById(R.id.brandIv);
            brandOffer = (TextView) itemView.findViewById(R.id.brandOfferTv);
            brandTitle = (TextView) itemView.findViewById(R.id.brandTv);
        }
    }
}
