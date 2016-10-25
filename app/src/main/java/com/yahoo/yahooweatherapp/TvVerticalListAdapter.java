package com.yahoo.yahooweatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class TvVerticalListAdapter extends RecyclerView.Adapter<TvVerticalListAdapter.ViewHolder> {

    private ArrayList<WeatherItemModel> dataList;
    private Context mContext;

    public TvVerticalListAdapter(Context context, ArrayList<WeatherItemModel> dataList) {
        notifyDataSetChanged();
        this.dataList = dataList;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView currentTime;

        protected TextView weatherCondition;

        protected TextView cityName;

        protected TextView weatherValue;

        protected ImageView cloudImage;

        public ViewHolder(View v) {
            super(v);
            currentTime = (TextView) v.findViewById(R.id.current_time);
            cloudImage = (ImageView) v.findViewById(R.id.cloud_image);
            weatherCondition = (TextView) v.findViewById(R.id.weather_condition);
            cityName = (TextView) v.findViewById(R.id.city_name);
            weatherValue = (TextView) v.findViewById(R.id.weather_value);

        }
    }

    @Override
    public TvVerticalListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical_single_card, viewGroup, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(TvVerticalListAdapter.ViewHolder itemRowHolder, int i) {


        WeatherItemModel singleItem = dataList.get(i);
        itemRowHolder.currentTime.setText(singleItem.getTime());
        itemRowHolder.cityName.setText(singleItem.getCityName());
        itemRowHolder.weatherCondition.setText(singleItem.getWeatherCondition());
        itemRowHolder.weatherValue.setText(singleItem.getWeatherValue());
        if (singleItem.getWeatherCondition().equals("Cloudy")) {
            itemRowHolder.cloudImage.setVisibility(View.VISIBLE);
        } else {
            itemRowHolder.cloudImage.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }


}