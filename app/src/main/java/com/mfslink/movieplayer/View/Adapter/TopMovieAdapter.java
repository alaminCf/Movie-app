package com.mfslink.movieplayer.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mfslink.movieplayer.Models.Result;
import com.mfslink.movieplayer.R;


import java.util.List;

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.MyViewHolder> {

    private Context context;
    private List<Result> list;

    public TopMovieAdapter(Context context, List<Result> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(R.layout.movie_rv_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(list.get(position).getTitle());
       holder.rdate.setText(list.get(position).getReleaseDate());
        holder.rating.setText("Rating" + " " + list.get(position).getVoteAverage().toString());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + list.get(position)
               .getPosterPath()).into(holder.mimage);


    }

    @Override
    public int getItemCount() {

        if (this.list!=null){
            return list.size();
        }else
            return 0;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView mimage;
        TextView title, rating, rdate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mimage = itemView.findViewById(R.id.mimage);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            rdate = itemView.findViewById(R.id.rdate);


        }
    }


}
