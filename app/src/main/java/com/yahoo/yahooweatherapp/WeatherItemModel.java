package com.yahoo.yahooweatherapp;


public class WeatherItemModel {
    private String cityName;
    private String time;
    private String weatherValue;
    private String weatherCondition;

    public String getCityName() {
        return cityName;
    }


    public String getTime() {
        return time;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }


    public String getWeatherValue() {
        return weatherValue;
    }


    public WeatherItemModel(String cityName, String time, String weatherValue, String weatherCondition) {

        this.cityName = cityName;
        this.time = time;
        this.weatherValue = weatherValue;
        this.weatherCondition = weatherCondition;
    }

}
