package com.yahoo.yahooweatherapp;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerVerticalDataAdapter extends RecyclerView.Adapter<RecyclerVerticalDataAdapter.ItemRowHolder> {

    private ArrayList<VerticalWeatherModel> dataList;
    private Context mContext;

    public RecyclerVerticalDataAdapter(Context context, ArrayList<VerticalWeatherModel> dataList) {
        notifyDataSetChanged();
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical_list_item, viewGroup, false);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {


         ArrayList singleSectionItems = dataList.get(i).getAllItemsInVertical();

        TvVerticalListAdapter itemListDataAdapter = new TvVerticalListAdapter(mContext, singleSectionItems);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);


        itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected RecyclerView recycler_view_list;

        public ItemRowHolder(View view) {
            super(view);

            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.vertical_recycle_view_list);

        }

    }

}