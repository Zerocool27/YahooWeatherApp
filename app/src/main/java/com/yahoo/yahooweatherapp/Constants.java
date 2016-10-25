package com.yahoo.yahooweatherapp;

/**
 * Created by fatihaktepe on 10/25/16.
 */

public interface Constants {
     String WEATHER_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20location,item.condition%20from%20weather.forecast%20where%20woeid%20in%20%28select%20woeid%20from%20geo.places%281%29%20where%20text%20in%20%28%22tokyo%22,%20%22new%20york%22,%20%22sao%20paulo%22,%20%22seoul%22,%20%22mumbai%22,%20%22delhi%22,%20%22jakarta%22,%20%22cairo%22,%20%22los%20angeles%22,%20%22buenos%20aires%22,%20%22moscow%22,%20%22shanghai%22,%20%22paris%22,%20%22istanbul%22,%20%22beijing%22,%20%22london%22,%20%22singapore%22,%20%22hong%20kong%22,%20%22sydney%22,%20%22madrid%22,%20%22rio%22%29%29&format=json";

}
