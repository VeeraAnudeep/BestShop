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
//        if (random != 2) {
        Glide.with(mContext)
                .load(url)
                .fitCenter()
                .into(viewHolder.brandIv);
//        } else {
//            viewHolder.brandIv.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bigbazaar));
//        }
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
