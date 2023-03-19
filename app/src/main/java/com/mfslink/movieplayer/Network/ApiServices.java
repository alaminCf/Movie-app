package com.mfslink.movieplayer.Network;

import com.mfslink.movieplayer.Models.MovieModel;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {


    @GET("3/movie/top_rated?api_key=665db733ed4aa4c3f26972d64c638d6e")
    Call<MovieModel> getTopMovie();


}
