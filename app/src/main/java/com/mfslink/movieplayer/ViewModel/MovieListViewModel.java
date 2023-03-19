package com.mfslink.movieplayer.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mfslink.movieplayer.Models.Result;
import com.mfslink.movieplayer.Response.MovieRepository;


import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepository mrepo;

    public MovieListViewModel(@NonNull Application application) {
        super(application);

        mrepo = MovieRepository.getInstance(application);

    }

    public LiveData<List<Result>> getTopRatedMoivieList(){
        return mrepo.getTopRateMovieList();
    }

}
