package com.mfslink.movieplayer.Response;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.mfslink.movieplayer.Models.MovieModel;
import com.mfslink.movieplayer.Models.Result;
import com.mfslink.movieplayer.Network.ApiServices;
import com.mfslink.movieplayer.Network.RetrofitInastance;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MutableLiveData mLiveData;
    private List<Result> mresult;
    private MovieModel movieModel;
    private static Context mcontext;
    private static MovieRepository instance;

    public static MovieRepository getInstance(Context context){

        if (instance==null){

            mcontext = context;
            instance = new MovieRepository();
        }
        return instance;
    }


    public MutableLiveData<List<Result>>  getTopRateMovieList(){


        if (mLiveData==null){

            mLiveData = new MutableLiveData<>();
        }

        ApiServices apiServices = RetrofitInastance.retroInstance().create(ApiServices.class);
               Call<MovieModel> call = apiServices.getTopMovie();
               call.enqueue(new Callback<MovieModel>() {
                   @Override
                   public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                       movieModel = response.body();
                      mresult = movieModel.getResults();

                      mLiveData.postValue(mresult);


                   }

                   @Override
                   public void onFailure(Call<MovieModel> call, Throwable t) {

                   }
               });

               return mLiveData;
    }


}
