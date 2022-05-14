package com.mohammad.khan.flixter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Headers;

import java.util.ArrayList;
import java.util.List;
import com.mohammad.khan.flixter.Movie;
import com.mohammad.khan.flixter.adapters.MovieAdapter;
import com.mohammad.khan.flixter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivityFliexter";
    List<Movie> movies;
    private String API_FOR_MOVIE_LIST=
            "https://api.themoviedb.org/3/movie/now_playing?api_key=1a63d1b47d81d3598f24a900ed02089e&language=en-US";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        movies = new ArrayList<>();
        MovieAdapter movieAdapter = new MovieAdapter(this, movies);

        // Set the adapter on the RecyclerView
        binding.rvMovies.setAdapter(movieAdapter);

        // Set a Layout Manager on the RecyclerView
        binding.rvMovies.setLayoutManager(new LinearLayoutManager(this));

        //Api call
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(API_FOR_MOVIE_LIST, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int i, Headers headers, JSON json) {
                        Log.e(TAG, String.valueOf(json));

                        JSONObject jsonObject = json.jsonObject;
                        try {
                            JSONArray results = jsonObject.getJSONArray("results");
                            Log.i(TAG, "Results: " + results.toString());
                            movies.addAll(Movie.fromJsonArray(results));
                            movieAdapter.notifyDataSetChanged();
                            Log.i(TAG, "Movies: " + movies.size());
                        } catch (JSONException e) {
                            Log.e(TAG, "Hit json exception", e);
                        }
                    }

                    @Override
                    public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                        Log.e(TAG, String.valueOf(s));
                    }
                }
        );
    }
}