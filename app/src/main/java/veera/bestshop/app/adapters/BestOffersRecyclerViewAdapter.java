package veera.bestshop.app.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import veera.bestshop.app.R;

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
        viewHolder.card.setBackground(ContextCompat.getDrawable(mContext, R.drawable.plane));
        viewHolder.brandOffer.setText("Offers Cashbacks on Domestic Filghts");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class BestOfferItemViewHolder extends RecyclerView.ViewHolder {
        TextView brandTitle;
        TextView brandOffer;
        CardView card;

        public BestOfferItemViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.card_view);
            brandOffer = (TextView) itemView.findViewById(R.id.brandOfferTv);
            brandTitle = (TextView) itemView.findViewById(R.id.brandTv);
        }
    }
}
