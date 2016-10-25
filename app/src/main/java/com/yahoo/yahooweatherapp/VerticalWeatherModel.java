package com.yahoo.yahooweatherapp;

import java.util.ArrayList;


public class VerticalWeatherModel {


    private ArrayList<WeatherItemModel> allItemsInSection;


    public VerticalWeatherModel() {

    }

    public VerticalWeatherModel(ArrayList<WeatherItemModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


    public ArrayList<WeatherItemModel> getAllItemsInVertical() {
        return allItemsInSection;
    }

    public void setAllItemsInVertical(ArrayList<WeatherItemModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

}
