package com.haikalharin.movieudemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.haikalharin.movieudemy.model.ResponseMovie;
import com.haikalharin.movieudemy.model.ResultsItem;
import com.haikalharin.movieudemy.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static String MOVIE_API = BuildConfig.MovieSecAPIKEY;

    RecyclerView recycler;
    List<ResultsItem> dataMovie = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerView);
//        //Dummy data
//        MovieModel movie1 = new MovieModel();
//        movie1.setJudulFilm("Judul Film");
//        movie1.setPosterFilm("https://image.tmdb.org/t/p/w220_and_h330_face/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg");
//
//        for (int i = 0; i <20 ; i++) {
//            dataMovie.add(movie1);
//        }
        getDataOnline();
        //3.Adapter
        recycler.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));

        //4.LayoutManager
        recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
    }

    private void getDataOnline() {

        Call<ResponseMovie> request = RetrofitConfig.getApiServiice().ambilDataMovie(MOVIE_API);
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if(response.isSuccessful()){
                    dataMovie = response.body().getResults();
                    recycler.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
                } else {
                    Toast.makeText(MainActivity.this,"Request Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Request Failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
