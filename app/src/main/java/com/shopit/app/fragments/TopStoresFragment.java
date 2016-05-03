package com.shopit.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopit.app.R;
import com.shopit.app.adapters.TopStoresAdapter;

/**
 * Created by veera on 3/5/16.
 */
public class TopStoresFragment extends Fragment {

    public TopStoresFragment() {
    }

    public static TopStoresFragment newInstance() {
        return new TopStoresFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            recyclerView.setAdapter(new TopStoresAdapter(context));
        }
        return view;
    }
}
