package com.mfslink.movieplayer.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInastance {


    public static String Base_URL = "https://api.themoviedb.org/";
    public static Retrofit retrofit;

    public static Retrofit retroInstance(){

        if (retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }


}
