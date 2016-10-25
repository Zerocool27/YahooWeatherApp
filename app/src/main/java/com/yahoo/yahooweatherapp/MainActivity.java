package com.yahoo.yahooweatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<VerticalWeatherModel> singVerticalList;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerVerticalDataAdapter vertical_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singVerticalList = new ArrayList<>();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });
        new JSONTask().execute();

    }


    public class JSONTask extends AsyncTask<String, String, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            return Utility.getJSONObject(Constants.WEATHER_URL);
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            ArrayList<WeatherItemModel> verticalWeatherList = new ArrayList<>();
            VerticalWeatherModel vm = new VerticalWeatherModel();
            try {
                JSONObject query = result.getJSONObject("query");
                JSONObject results = query.getJSONObject("results");
                JSONArray channel = results.getJSONArray("channel");
                for (int i = 0; i < channel.length(); i++) {
                    JSONObject eachObj = channel.getJSONObject(i);
                    JSONObject location = eachObj.getJSONObject("location");
                    JSONObject item = eachObj.getJSONObject("item");
                    JSONObject condition = item.getJSONObject("condition");
                    WeatherItemModel newWeather = new WeatherItemModel(location.getString("city"), condition.getString("date"), condition.getString("temp"), condition.getString("text"));
                    verticalWeatherList.add(newWeather);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Collections.sort(verticalChannelList);
            vm.setAllItemsInVertical(verticalWeatherList);
            singVerticalList.add(vm);
            RecyclerView my_vertical_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view_list);

            my_vertical_recycler_view.setHasFixedSize(true);

            vertical_adapter = new RecyclerVerticalDataAdapter(MainActivity.this, singVerticalList);

            my_vertical_recycler_view.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

            my_vertical_recycler_view.setAdapter(vertical_adapter);

            onItemsLoadComplete();

        }
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...
        vertical_adapter.notifyDataSetChanged();
        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    void refreshItems() {
        new JSONTask().execute();
    }
}
