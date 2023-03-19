package com.mfslink.movieplayer.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mfslink.movieplayer.Models.MovieModel;
import com.mfslink.movieplayer.Models.Result;
import com.mfslink.movieplayer.R;
import com.mfslink.movieplayer.View.Adapter.TopMovieAdapter;
import com.mfslink.movieplayer.ViewModel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private MovieListViewModel mviewModel;
    private TopMovieAdapter movieAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = findViewById(R.id.mrecyclerview);
        GridLayoutManager LayoutManager = new GridLayoutManager(this, 2);
        mrecyclerView.setLayoutManager(LayoutManager);

        mviewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        mviewModel.getTopRatedMoivieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                movieAdapter = new TopMovieAdapter(MainActivity.this, results);
                mrecyclerView.setAdapter(movieAdapter);



            }
        });


    }
}