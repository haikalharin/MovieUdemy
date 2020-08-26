package com.haikalharin.movieudemy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haikalharin.movieudemy.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<ResultsItem> data = new ArrayList<>();

    public MovieAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    //Menyambungkan Layout Item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup,false);
        return new MyViewHolder(itemView);
    }

    //set datanya
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.tvJudul.setText(data.get(position).getTitle());
        Glide.with(context)
             .load("https://image.tmdb.org/t/p/w500"+data.get(position).getPosterPath())
             .into(myViewHolder.ivPoster);
    }

    //jumlah datanya
    @Override
    public int getItemCount() {
        return data.size();
    }

    //mengenalkan komponen dalam item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul;
        ImageView ivPoster;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            ivPoster = itemView.findViewById(R.id.iv_item_gambar);
        }

    }
}

