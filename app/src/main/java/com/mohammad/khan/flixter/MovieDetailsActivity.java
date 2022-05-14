package com.mohammad.khan.flixter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.mohammad.khan.flixter.databinding.ActivityMovieDetailsBinding;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.parceler.Parcels;

import okhttp3.Headers;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String TAG = "MovieDetailsActivity";

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieDetailsBinding binding = ActivityMovieDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        movie = Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        getSupportActionBar().setTitle("Now Playing - " + movie.getTitle());

        binding.tvTitle.setText(movie.getTitle());
        binding.tvOverview.setText(movie.getOverview());
        binding.rbVoteAverage.setRating(movie.getVoteAverage().floatValue() / 2.0f);
        binding.tvRating.setText("(" + movie.getVoteAverage() + "/10)");

        String imageUrl;
        int placeholder;
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageUrl = movie.getBackdropPath();
            placeholder = R.drawable.flicks_backdrop_placeholder;
        } else {
            imageUrl = movie.getPosterPath();
            placeholder = R.drawable.flicks_movie_placeholder;
        }

        Glide.with(this)
                .load(imageUrl)
                .placeholder(placeholder)

                .into(binding.ivVideo);

        String videoURL = "https://api.themoviedb.org/3/movie/" + movie.getId() + "/videos?api_key=" + getString(R.string.youtube_api_key);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(videoURL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    for (int x = 0; x < results.length(); x++) {
                        if (results.getJSONObject(0).getString("site").equals("YouTube")) {
                            movie.setVideoId(results.getJSONObject(0).getString("key"));
                            Log.i(TAG, "videoId: " + movie.getVideoId());
                            break;
                        }
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }

    public void playTrailer(View view) {
        if (movie.getVideoId() != null) {
            Intent intent = new Intent(this, MovieTrailerActivity.class);
            intent.putExtra("key", movie.getVideoId());
            startActivity(intent);
        }
    }
}